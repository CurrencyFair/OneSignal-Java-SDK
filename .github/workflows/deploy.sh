#!/usr/bin/env bash
set -e

# update current version number to a TAG version if this is a tag build
if [ "$GITHUB_REF_TYPE" = "tag" ]
then
    echo "on a tag -> set pom.xml <version> to $GITHUB_REF_NAME for release"
    mvn --settings .github/workflows/mvnsettings.xml org.codehaus.mojo:versions-maven-plugin:2.3:set -DnewVersion=$GITHUB_REF_NAME
else
    echo "not on a tag -> keep snapshot version in pom.xml"
fi

# cleanup and generate gpg keys
if [ -d "$HOME/.gnupg" ]; then
    shred -v ~/.gnupg/*
    rm -rf ~/.gnupg
fi

source .github/workflows/gpg.sh

# DEPLOY \o/
mvn clean deploy --settings .github/workflows/mvnsettings.xml -DskipTests=true --batch-mode --update-snapshots

# cleanup gpg keys, just to be safe
find ~/.gnupg/ -type f -exec shred -v {} \;
rm -rf ~/.gnupg
