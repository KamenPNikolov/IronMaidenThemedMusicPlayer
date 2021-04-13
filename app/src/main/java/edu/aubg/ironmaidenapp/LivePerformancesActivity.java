package edu.aubg.ironmaidenapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubePlayerView;


public class LivePerformancesActivity extends AppCompatActivity {
    private WebView webView;
    private int index=0;
    //an array containing the URL's of live performances in YouTube
    private String[] urls={"https://www.youtube.com/watch?v=iLtYsr72L8s","https://www.youtube.com/watch?v=vtWm-S4hUC8","https://www.youtube.com/watch?v=FxQ6HuOy2Xw","https://www.youtube.com/watch?v=gm5R3ClMmgo","https://www.youtube.com/watch?v=xmzUiwkRheY"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_performances);
      //Link to xml
       webView =(WebView) findViewById(R.id.webviewlive);
       //Set to chrome
       webView.setWebChromeClient(new WebChromeClient(){});
        // Enable Javascript
       webView.getSettings().setJavaScriptEnabled(true);
    }
    public void selectVideo(View view)
    {
        if(view == findViewById(R.id.liveperformancesButton1))
    {
        webView.loadUrl(urls[0]);
    }
        if(view == findViewById(R.id.liveperformancesButton2))
        {
            webView.loadUrl(urls[1]);
        }
        if(view == findViewById(R.id.liveperformancesButton3))
        {
            webView.loadUrl(urls[2]);
        }
        if(view == findViewById(R.id.liveperformancesButton4))
        {
            webView.loadUrl(urls[3]);
        }
        if(view == findViewById(R.id.liveperformancesButton5))
        {
            webView.loadUrl(urls[4]);
        }


    }

}
