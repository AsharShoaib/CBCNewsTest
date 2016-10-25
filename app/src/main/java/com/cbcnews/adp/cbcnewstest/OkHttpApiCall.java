package com.cbcnews.adp.cbcnewstest;

import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by asharshoaib on 2016-10-24.
 */
public class OkHttpApiCall {
    public static String GET(OkHttpClient client, HttpUrl url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
//        Log.d("Response", response.body().string());
        return response.body().string();
    }

    public static class RequestBuilder {

        public static HttpUrl buildURL() {
            return new HttpUrl.Builder()
                    .scheme("http")
                    .host("cbc.ca")
                    .addPathSegment("m")
                    .addPathSegment("config")
                    .addPathSegment("apps")
                    .addPathSegment("samples")
                    .addPathSegment("cbc-sample-lineup.json")
                    .build();
        }
    }
}
