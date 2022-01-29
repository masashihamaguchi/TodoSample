package com.masashi.todosample

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by Masashi Hamaguchi on 2022/01/29.
 */

class RealmApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .allowWritesOnUiThread(true)
            .build()
        Realm.setDefaultConfiguration(realmConfig)
    }
}