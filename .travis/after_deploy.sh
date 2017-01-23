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

# increment version to the next snapshot version, commit and push to repository
if [ ! -z "$TRAVIS_TAG" ]
then
    # Get the deploy key by using Travis's stored variables to decrypt deploy_key.enc
    openssl aes-256-cbc \
        -K $encrypted_dd04a63e1379_key \
        -iv $encrypted_dd04a63e1379_iv \
        -in .travis/github_deploy_key.enc \
        -out .travis/github_deploy_key -d
    chmod 600 .travis/github_deploy_key
    eval `ssh-agent -s`
    ssh-add .travis/github_deploy_key
    git config --global user.name "$GIT_NAME"
    git config --global user.email "$GIT_EMAIL"

    # increment version to the next snapshot version
    increment_version_to_next_snapshot $TRAVIS_TAG
    echo "on a tag -> set pom.xml <version> to next SNAPSHOT $new_snapshot"
    mvn --settings .travis/mvnsettings.xml org.codehaus.mojo:versions-maven-plugin:2.3:set -DnewVersion=$new_snapshot
    mvn --settings .travis/mvnsettings.xml org.codehaus.mojo:versions-maven-plugin:2.3:commit

    # Save some useful information
    REPO=$(git config remote.origin.url)
    REPO=${REPO/https:\/\/github.com\//git@github.com:}
    REPO_NAME=$(basename $REPO)
    TARGET_DIR=$(mktemp -d /tmp/$REPO_NAME.XXXX)
    git clone --branch master ${REPO} ${TARGET_DIR}
    yes | cp -f pom.xml $TARGET_DIR/
    cd $TARGET_DIR
    # Finally add changed pom.xml and commit
    git add pom.xml
    git commit -m "[skip ci] [Travis-CI] next snapshot version via Travis build $TRAVIS_BUILD_NUMBER"
    # Now that we're all set up, we can push
    git push $REPO master
fi
