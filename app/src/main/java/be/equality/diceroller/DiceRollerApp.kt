package be.equality.diceroller

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree



class DiceRollerApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

}