@title[Hello Android]

#### Lesson 1
# DiceRoller

@snap[south span-40 text-gray text-05]
![Android logo](assets/img/logo.jpeg)
@snap[north span-100 text-08]
---
@snap[north span-100 text-08]
## Before you start
@snapend

Make sure you have completed the lesson from [Udacity](https://classroom.udacity.com/courses/ud9012).
 
This slide deck includes some extra features which are interesting for future Android Projects. 

---
@snap[north span-100 text-08]
## Say goodbye to `findViewById()`
@snap[north span-100 text-08]


**Kotlin Android Extensions** are a Kotlin plugin that is included in the regular one,
and that will allow finding views from
 
 - Activities
 - Fragments
 - Views 
 
 in a seamless way, without using the `findViewById` method.

+++?code=app/build.gradle&lang=groovy

+++?code=app/src/main/java/be/equality/diceroller/MainActivity.kt&lang=kotlin

---
@snap[north span-100 text-08]
## Logging
@snapend


The Logcat window in Android Studio displays system messages, such as

- garbage collection messages
- UI messages
- messages that you added to your app with the Log class. 

It displays messages in real time and keeps a history so you can view older messages.

+++

Using the logger is displayed [here](https://developer.android.com/studio/debug/am-logcat). 

+++

Make sure to apply the **best practice**: 

@quote[remove all logging functionality as soon as the feature is fully implemented and thoroughly tested, before deployment to production.]

+++

To enable your logs statements calls only during development phase,
Android offers you the `BuildConfig.DEBUG` property. 

This flag is set automatically to false when an application is deployed into an Android Application Package (APK)
for production and is set back to `true` during development.

---
@snap[north span-100 text-08]
## TIMBER
@snapend

There is a simple library called Timber which can log your messages and gives you the control 
over the flow of logs. Timber is a library developed by developer Jake Wharton, 
who has made a lot of interesting and helpful libraries.

+++

We refer to [this site](https://github.com/JakeWharton/timber) to see on how to use this library.


+++

Check out `DiceRollerpp` which extends `Application`. 

- This is a base class for maintaining global application state. 
- You can provide your own implementation by creating a subclass and specifying the 
fully-qualified name of this subclass as the `"android:name"` attribute in your 
Manifest’s `<application>` tag. 
- Your subclass of the Application class is instantiated before any other class when 
the process for your application/package is created.

+++?code=app/src/main/AndroidManifest.xml&lang=xml

+++?code=app/src/main/java/be/equality/diceroller/DiceRollerApp.kt&lang=kotlin

---
@snap[north span-100 text-08]
## Versioning
@snapend
We want to make distinctions between the different versions of our application.
Semantic Versioning (SemVer) is a universal way of versioning software development projects.

One way of doing this in Android: [check out this artile](https://medium.com/@maxirosson/versioning-android-apps-d6ec171cfd82)

+++?code=build.gradle&lang=groovy
 
