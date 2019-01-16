package com.monteoliva.webteste;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private WebUtil webUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webUtil = findViewById(R.id.webUtil);

        loadPage("http://192.168.122.232:3001");

    }

    /**
     * Metodo de inicializacao
     */
    private void loadPage(final String loadURL) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() { webUtil.load(loadURL); }
        }, 200);
    }

}