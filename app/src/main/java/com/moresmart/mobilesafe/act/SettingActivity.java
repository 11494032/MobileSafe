package com.moresmart.mobilesafe.act;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.moresmart.mobilesafe.R;
import com.moresmart.mobilesafe.view.SettingItemView;

/**
 * Created by Administrator on 2017/8/27.
 */

public class SettingActivity extends Activity{

    private SettingItemView siv_update;

    private SharedPreferences sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_setting);
        siv_update = (SettingItemView) findViewById( R.id.siv_update );

        sp = getSharedPreferences( "config", MODE_PRIVATE );

        boolean auto_update = sp.getBoolean("auto_update",false);
        siv_update.setTitle("自动跟新设置");
        if( auto_update ) {
            siv_update.setDesc("自动跟新已经开启");
            siv_update.setChecked( true);
        }
        else
        {
            siv_update.setDesc("自动跟新已经关闭");
            siv_update.setChecked( false);
        }

        siv_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //判断当前勾选状态

                if( siv_update.isChecked() )
                {
                    siv_update.setDesc("自动跟新已经关闭");
                    siv_update.setChecked( false);
                    sp.edit().putBoolean("auto_update",false).commit();
                }
                else
                {
                    siv_update.setDesc("自动跟新已经开启");
                    siv_update.setChecked( true);
                    sp.edit().putBoolean("auto_update",true).commit();
                }
            }
        });
    }
}
