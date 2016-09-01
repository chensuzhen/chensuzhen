package com.example.administrator.mydaily;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.administrator.mydaily.model.TopStory;

/**
 * Created by Administrator on 2016/8/19.
 */
public class StoryDetailActivity extends Activity {
    private WebView mWebView;
    private TopStory topStory;
    private String storyDetailURL = "http://daily.zhihu.com/story";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsdetail);
        mWebView = (WebView) findViewById(R.id.id_webview);

        topStory = (TopStory) getIntent().getSerializableExtra("topStory");

        setWebView(mWebView);
        mWebView.loadUrl(storyDetailURL);



    }

    private void setWebView(WebView mWebView) {
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setLoadsImagesAutomatically(true);
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);
    }

    public static void startActivity(Context context, TopStory topStory) {

    }

}
