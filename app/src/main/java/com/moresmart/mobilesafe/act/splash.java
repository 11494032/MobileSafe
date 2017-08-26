package com.moresmart.mobilesafe.act;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.moresmart.mobilesafe.R;
import com.moresmart.mobilesafe.utils.VersionUtil;

public class splash extends AppCompatActivity {


    private TextView tv_version;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tv_version = (TextView) findViewById( R.id.tv_version );
        tv_version.setText("版本号:"+VersionUtil.getVersionName( splash.this));

        checkVersion();
    }

    public void checkVersion()
    {
        loadMainUI();
    }
    public void loadMainUI()
    {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();

    }

}
