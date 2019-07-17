package com.edgar.alc;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button profile, load_webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("ALC 4 Phase 1");

        profile = findViewById(R.id.profile_button);
        load_webview = findViewById(R.id.alc_webview);

    }

    void goToProfile(View view) {
        Boolean networkStatus = isOnline(); // refactor this later to something like if(isOnline()){...}
        //Toast.makeText(this, "Go to profile " + networkStatus, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, profileActivity.class);
        startActivity(intent);
    }

    void loadWebview(View view) {
        //Toast.makeText(this, "Go to alc web site", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, webviewActivity.class);
        startActivity(intent);
    }

    public boolean isOnline(){
        ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}
