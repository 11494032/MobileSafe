package com.moresmart.mobilesafe.act;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.moresmart.mobilesafe.R;

/**
 * Created by Administrator on 2017/8/27.
 */

public class Setting1Activity extends BaseActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting1);



    }

    @Override
    public void prePage() {

    }

    @Override
    public void nextPage() {
        startActivity( new Intent( this, Setting2Activity.class));
        finish();
        overridePendingTransition( R.anim.tran_in, R.anim.tran_out);
    }

    public  void nextClick(View view)
    {
        nextPage();
    }

}
