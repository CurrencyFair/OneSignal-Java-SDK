#!/usr/bin/env bash
if [ ! -z "$TRAVIS_TAG" ]
then
    echo "on a tag -> set pom.xml <version> to $TRAVIS_TAG"
    mvn --settings .travis/mvnsettings.xml org.codehaus.mojo:versions-maven-plugin:2.3:set -DnewVersion=$TRAVIS_TAG 1>/dev/null 2>/dev/null
else
    echo "not on a tag -> keep snapshot version in pom.xml"
fi

mvn clean deploy --settings .travis/mvnsettings.xml -DskipTests=true -B -U
