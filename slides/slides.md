---
author: Jens Buysse, Harm De Weirdt
title: Dice Roller application
date: September, 2019
---

# Lesson 1

## DiceRoller

![](assets/img/logo.jpeg){#id .class width=150}

# Before you start

## Prepare

-   Make sure you have completed the lesson from [Udacity](https://classroom.udacity.com/courses/ud9012).
 
> This slide deck includes some extra features which are interesting for future *Android Projects*. 


# Say goodbye to `findViewById()`

## Kotlin Android Extensions

> a Kotlin plugin that is included in the regular one,
and that will allow finding views from
 
 - Activities
 - Fragments
 - Views 
 
in a seamless way, without using the `findViewById` method.

## 

```{.kotlin}
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    roll_button.text = getString(R.string.lets_roll)
    roll_button.setOnClickListener {
        rollDice()
        Timber.i("Pressed the button")
    }
}
```

# Logging

## Logcat window

The Logcat window in *Android Studio* displays system messages, such as

- garbage collection messages
- UI messages
- messages that you added to your app with the Log class. 

It displays messages in real time and keeps a history so you can view older messages.

## Using the logger

Using the logger is displayed [here](https://developer.android.com/studio/debug/am-logcat). 

##

Make sure to apply the **best practice**: 

> remove all logging functionality as soon as the feature is fully implemented and thoroughly tested,
 before deployment to production

##

- To enable your log statements calls only during development phase,
Android offers you the `BuildConfig.DEBUG` property. 

- This flag is set automatically to false when an application is deployed into an Android Application Package (APK)
for production and is set back to `true` during development.


# TIMBER

## 
- There is a simple library called **Timber** which can log your messages and gives you the control 
over the flow of logs. 

- Timber is a library developed by developer Jake Wharton, 
who has made a lot of interesting and helpful libraries.

## TIMBER

We refer to [this site](https://github.com/JakeWharton/timber) to see on how to use this library.


## Timber

Check out `DiceRollerpp` which extends `Application`. 

- This is a base class for maintaining global application state.  
- Your subclass of the Application class is instantiated before any other class when 
the process for your application/package is created.

## 

```kotlin
class DiceRollerApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

}

```

## 

- You can provide your own implementation by creating a subclass and specifying the 
fully-qualified name of this subclass as the `"android:name"` attribute in your 
Manifest’s `<application>` tag. 


##

````xml
<application
        android:name=".DiceRollerApp"
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme"
        tools:ignore="AllowBackup,GoogleAppIndexingWarning">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
````



# Versioning

## SemVer

We want to make distinctions between the different versions of our application.
Semantic Versioning (SemVer) is a universal way of versioning software development projects.

One way of doing this in Android: [check out this artile](https://medium.com/@maxirosson/versioning-android-apps-d6ec171cfd82)

## 
````java

private Integer generateVersionCode() {
    return ext.minimumSdkVersion * 10000000 + ext.versionMajor * 10000 + ext.versionMinor * 100 + ext.versionPatch
}

private String generateVersionName() {
    String versionName = "${ext.versionMajor}.${ext.versionMinor}.${ext.versionPatch}"
    if (ext.versionClassifier == null && ext.isSnapshot) {
        ext.versionClassifier = "SNAPSHOT"
    }

    if (ext.versionClassifier != null) {
        versionName += "-" + ext.versionClassifier
    }
    return versionName
}

````

##
```groovy
defaultConfig {
        applicationId "be.equality.diceroller"
        minSdkVersion project.ext.minimumSdkVersion
        targetSdkVersion project.ext.targetSdkVersion
        versionCode generateVersionCode()
        versionName generateVersionName()
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }
```
