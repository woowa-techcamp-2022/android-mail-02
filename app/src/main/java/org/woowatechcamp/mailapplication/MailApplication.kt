package org.woowatechcamp.mailapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.woowatechcamp.mailapplication.util.MailDebugTree
import timber.log.Timber

@HiltAndroidApp
class MailApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(MailDebugTree())
        }
    }
}
