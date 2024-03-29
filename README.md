[![Build Status](http://35.224.240.121/jenkins/buildStatus/icon?job=diceroller%2Fmaster)](http://35.224.240.121/jenkins/job/diceroller/job/master/)

# Dice Roller

This is a simple application which allows the user to simulate a dice. The user is able to roll
the dice. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine
for development and testing purposes.

### Prerequisites

- Android Studio
- Gradle


### Installing

Checkout the repository, build the APK using Android Studio and test on your physical device or emulator. 

## Running the tests

### Unit tests

```
./gradlew test
```

### Instrumentation tests

```
./gradlew connectedAndroidTest
```


## Built With

* [Android Studio](https://developer.android.com/studio) - The IDE used
* [Gradle](https://gradle.org/) - Build system

## Generating the slideset

We use [Pandoc](https://pandoc.org/index.html) together with [Reveal.js](https://pandoc.org/index.html) to generate the slides.

- To generate your setup, follow this [tutorial](https://github.com/jgm/pandoc/wiki/Using-pandoc-to-produce-reveal.js-slides) 
- To generate the slides, `cd` into the slides directory and run the following code:

```bash
pandoc -t revealjs -s -o slides.html slides.md -V revealjs-url=./reveal.js
```

## Versioning

We use [SemVer](http://semver.org/) for versioning. 

## Authors

* **Jens Buysse** - *Initial work*
* **Harm De Weirdt** - *Review*

