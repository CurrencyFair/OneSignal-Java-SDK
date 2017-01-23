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
    mvn --settings .travis/mvnsettings.xml org.codehaus.mojo:versions-maven-plugin:2.3:set -DnewVersion=$new_snapshot
    mvn --settings .travis/mvnsettings.xml org.codehaus.mojo:versions-maven-plugin:2.3:commit
    git config user.name "Travis CI"
    git config user.email "build@travis-ci.org"
    git remote add upstream "https://$GITHUB_API_TOKEN@github.com/CurrencyFair/OneSignal-Java-SDK.git"
    git fetch upstream
    git add pom.xml
    git commit -m "[Travis-CI] next snapshot version"
    git push --quiet upstream master > /dev/null 2>&1
fi
