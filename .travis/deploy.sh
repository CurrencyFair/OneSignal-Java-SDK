#!/usr/bin/env bash
set -e

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
    find ~/.gnupg/ -type f -exec shred -v {} \;
    rm -rf ~/.gnupg
fi
