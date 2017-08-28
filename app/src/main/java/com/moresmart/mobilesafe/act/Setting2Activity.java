package com.moresmart.mobilesafe.act;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.moresmart.mobilesafe.R;

/**
 * Created by Administrator on 2017/8/28.
 */

public class Setting2Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_setting2);
    }

    public  void nextClick( View view)
    {
        startActivity( new Intent( this, Setting3Activity.class));
        overridePendingTransition( R.anim.tran_in, R.anim.tran_out);
    }

    public  void preClick( View view)
    {
        startActivity( new Intent( this, Setting1Activity.class));
        overridePendingTransition( R.anim.tran_previous_in, R.anim.tran_previous_out);
    }
}
