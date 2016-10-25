package com.cbcnews.adp.cbcnewstest;

import android.app.Application;

import com.cbcnews.adp.cbcnewstest.Models.News;
import com.cbcnews.adp.cbcnewstest.Models.NewsModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.annotations.RealmModule;

/**
 * Created by asharshoaib on 2016-10-24.
 */

public class App extends Application {

    public static final String GETURL = "CBC_NEWS_URL";

    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

}
