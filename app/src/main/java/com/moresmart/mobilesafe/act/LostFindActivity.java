package com.moresmart.mobilesafe.act;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.moresmart.mobilesafe.R;

/**
 * Created by Administrator on 2017/8/28.
 */

public class LostFindActivity extends Activity {
    private SharedPreferences sp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sp = getSharedPreferences("config", MODE_PRIVATE);
        boolean configed = sp.getBoolean("configed", false);// 判断是否进入过设置向导
        if (configed) {
            setContentView( R.layout.activity_lostfind );
        }
        else
        {
            startActivity( new Intent(LostFindActivity.this,Setting1Activity.class));
            finish();
        }


    }

    /**
     * 重新进入设置向导
     *
     * @param view
     */
    public void reEnter(View view) {
        startActivity(new Intent(this, Setting1Activity.class));
        finish();
    }
}
