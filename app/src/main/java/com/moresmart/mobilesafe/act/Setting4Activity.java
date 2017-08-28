package com.moresmart.mobilesafe.act;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.moresmart.mobilesafe.R;

/**
 * Created by Administrator on 2017/8/29.
 */

public class Setting4Activity extends Activity {

    private  SharedPreferences sp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting4);

        sp = getSharedPreferences("config", MODE_PRIVATE);

    }

    public  void preClick( View view)
    {
        startActivity( new Intent( this, Setting3Activity.class));
    }

    public  void nextClick( View view)
    {
         sp.edit().putBoolean("configed", true).commit();
         startActivity( new Intent( this, LostFindActivity.class));
    }
}
