#!/usr/bin/env bash
set -e

if [ ! -z "$TRAVIS_TAG" ]
then
    echo "on a tag -> set pom.xml <version> to $TRAVIS_TAG"
    mvn --settings .travis/mvnsettings.xml org.codehaus.mojo:versions-maven-plugin:2.3:set -DnewVersion=$TRAVIS_TAG
else
    echo "not on a tag -> keep snapshot version in pom.xml"
fi

if [ ! -z "$TRAVIS" -a -f "$HOME/.gnupg" ]; then
    shred -v ~/.gnupg/*
    rm -rf ~/.gnupg
fi

source .travis/gpg.sh

mvn clean deploy --settings .travis/mvnsettings.xml -DskipTests=true --batch-mode --update-snapshots

if [ ! -z "$TRAVIS" ]; then
    shred -v ~/.gnupg/*
    rm -rf ~/.gnupg
fi
