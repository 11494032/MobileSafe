package com.moresmart.mobilesafe.act;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by Administrator on 2017/8/28.
 */

public class LostFindActivity extends Activity {
    private SharedPreferences sp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sp = getSharedPreferences("config", MODE_PRIVATE);
        boolean saved = sp.getBoolean("saved",false);
        if( saved )
        {

        }
        else
        {
            startActivity( new Intent(LostFindActivity.this,Setting1Activity.class));
            finish();
        }


    }
}
