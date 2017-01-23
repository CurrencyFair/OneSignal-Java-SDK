#!/usr/bin/env bash
set -e

increment_version_to_next_snapshot ()
# http://stackoverflow.com/a/8659330/5226815
{
  declare -a part=( ${1//\./ } )
  declare    new
  declare -i carry=1

  for (( CNTR=${#part[@]}-1; CNTR>=0; CNTR-=1 )); do
    len=${#part[CNTR]}
    new=$((part[CNTR]+carry))
    [ ${#new} -gt $len ] && carry=1 || carry=0
    [ $CNTR -gt 0 ] && part[CNTR]=${new: -len} || part[CNTR]=${new}
  done
  new="${part[*]}"
  new_snapshot="${new// /.}-SNAPSHOT"
}

# update current version number to a TAG version if this is a tag build
if [ ! -z "$TRAVIS_TAG" ]
then
    echo "on a tag -> set pom.xml <version> to $TRAVIS_TAG for release"
    mvn --settings .travis/mvnsettings.xml org.codehaus.mojo:versions-maven-plugin:2.3:set -DnewVersion=$TRAVIS_TAG
else
    echo "not on a tag -> keep snapshot version in pom.xml"
fi

# cleanup and generate gpg keys
if [ ! -z "$TRAVIS" -a -f "$HOME/.gnupg" ]; then
    shred -v ~/.gnupg/*
    rm -rf ~/.gnupg
fi

source .travis/gpg.sh

# DEPLOY \o/
mvn clean deploy --settings .travis/mvnsettings.xml -DskipTests=true --batch-mode --update-snapshots

# cleanup gpg keys, just to be safe
if [ ! -z "$TRAVIS" ]; then
    shred -v ~/.gnupg/*
    rm -rf ~/.gnupg
fi

# increment version to the next snapshot version, commit and push to repository
if [ ! -z "$TRAVIS_TAG" ]
then
    increment_version_to_next_snapshot $TRAVIS_TAG
    echo "on a tag -> set pom.xml <version> to next SNAPSHOT $new_snapshot"
    git checkout master
    mvn --settings .travis/mvnsettings.xml org.codehaus.mojo:versions-maven-plugin:2.3:set -DnewVersion=$new_snapshot
    mvn --settings .travis/mvnsettings.xml org.codehaus.mojo:versions-maven-plugin:2.3:commit
    # Save some useful information
    REPO=`git config remote.origin.url`
    SSH_REPO=${REPO/https:\/\/github.com\//git@github.com:}
    git config user.name "Travis CI"
    git config user.email "build@travis-ci.org"
    git add pom.xml
    git commit -m "[Travis-CI] next snapshot version"

    # Get the deploy key by using Travis's stored variables to decrypt deploy_key.enc
    openssl aes-256-cbc -K $encrypted_7a1322f4b03c_key -iv $encrypted_7a1322f4b03c_iv -in .travis/deploy_key.enc -out .travis/deploy_key -d
    chmod 600 .travis/deploy_key
    eval `ssh-agent -s`
    ssh-add .travis/deploy_key

    # Now that we're all set up, we can push.
    git push $SSH_REPO master
fi
