package com.moresmart.mobilesafe.act;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.moresmart.mobilesafe.R;

/**
 * Created by Administrator on 2017/8/29.
 */

public class Setting3Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting3);
    }

    public  void nextClick( View view)
    {
        startActivity( new Intent( this, Setting4Activity.class));
    }

    public  void preClick( View view)
    {
        startActivity( new Intent( this, Setting2Activity.class));
    }
}
