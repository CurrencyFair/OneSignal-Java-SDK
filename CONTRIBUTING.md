# Contributing

We love pull requests from everyone. By participating in this project, you
agree to abide by the [Contributor Covenant Code of Conduct](http://contributor-covenant.org/version/1/4/).

Fork, then clone the repo:

```
git clone git@github.com:your-username/OneSignal-Java-SDK.git
```

## Making Changes

* Create a topic branch from where you want to base your work.
  * This is usually the master branch.
  * To quickly create a topic branch based on master; `git checkout -b my_contribution master`. Please avoid working 
    directly on the `master` branch.
* Make commits of logical units.
* Make sure your commit messages are descriptive.
* Make sure your code compiles and adheres to CurrencyFair's coding standards: `mvn clean package`

## Submitting Changes

* Push your changes to a topic branch in your fork of the repository.
* [Submit a pull request](https://github.com/CurrencyFair/OneSignal-Java-SDK/compare/).
* The CurrencyFair team will look at your Pull Request. We may suggest some changes or improvements or alternatives. 
  Your code will be accepted when two people approve the pull request.
* After feedback has been given we expect responses within two weeks. After two weeks we may close the pull request if 
  it isn't showing any activity.

## Releasing

* Your `pom.xml` should always use SNAPSHOT `<version>x.y.z-SNAPSHOT</version>` version.
* If you push a commit to master of your repository, a new snapshot will be uploaded and is available as `x.y.z-SNAPSHOT`.
* The owner of the repo has to `git tag x.y.z` and `git push --tags` afterwards. This will make `x.y.z` of your library 
  available at maven central.
