package com.cbcnews.adp.cbcnewstest.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.cbcnews.adp.cbcnewstest.App;
import com.cbcnews.adp.cbcnewstest.R;


/**
 * Created by asharshoaib on 2016-10-24.
 */

public class WebViewActivity extends Activity {
    private WebView webView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        webView = (WebView) findViewById(R.id.webView1);
        WebSettings webSettings = webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(getIntent().getExtras().getString(App.GETURL));

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack(); // Go to previous page
            return;
        }
        // Use this as else part
        super.onBackPressed();
        finish();
    }
}
