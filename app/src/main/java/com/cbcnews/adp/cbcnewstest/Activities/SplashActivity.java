package com.cbcnews.adp.cbcnewstest.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cbcnews.adp.cbcnewstest.Models.News;
import com.cbcnews.adp.cbcnewstest.Models.NewsArrayList;
import com.cbcnews.adp.cbcnewstest.OkHttpApiCall;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import io.realm.Realm;
import okhttp3.OkHttpClient;

/**
 * Created by asharshoaib on 2016-10-24.
 */

public class SplashActivity extends AppCompatActivity {

    public NewsArrayList newsList;
    private OkHttpClient client;
    private String response;
    private Realm realm;
    private News[] news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = new OkHttpClient();
        loadContent();
    }

    private void loadContent() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                Realm realm = Realm.getDefaultInstance();
                try {
                    response = OkHttpApiCall.GET(client, OkHttpApiCall.RequestBuilder.buildURL());
                    Gson gson = new Gson();

                    news = gson.fromJson(response, News[].class);


                    realm.beginTransaction();
                    for (final News n : news) {
                        realm.copyToRealmOrUpdate(n);
                    }
                    realm.commitTransaction();
                    Log.d("Response", response);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    realm.close();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                done();
            }
        }.execute();
    }

    private void done() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
