package com.moresmart.mobilesafe.act;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;

import com.moresmart.mobilesafe.R;
import com.moresmart.mobilesafe.view.SettingItemView;

/**
 * Created by Administrator on 2017/8/28.
 */

public class Setting2Activity extends BaseActivity {


    private SettingItemView settingItemView;

    private SharedPreferences sp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_setting2);

        sp = getSharedPreferences("config",MODE_PRIVATE);



        String sim = sp.getString("sim", null);



        settingItemView =  (SettingItemView) findViewById( R.id.siv_sim );

        if(TextUtils.isEmpty( sim ))
        {
            settingItemView.setChecked( false );
        }
        else
        {
            settingItemView.setChecked( true );
        }

        settingItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("siv_update.isChecked() " + settingItemView.isChecked() );
               if( settingItemView.isClickable())
               {
                   settingItemView.setChecked( false );
                   sp.edit().remove("sim").commit();
               }
               else {
                  TelephonyManager telephonyManager = (TelephonyManager) getSystemService( TELEPHONY_SERVICE);

                   String serialNumber = telephonyManager.getSimSerialNumber();
                   settingItemView.setChecked( true );
                   sp.edit().putString("sim",serialNumber).commit();
               }
            }
        });
    }

    @Override
    public void prePage() {
        startActivity( new Intent( this, Setting1Activity.class));
        finish();
        overridePendingTransition( R.anim.tran_previous_in, R.anim.tran_previous_out);
    }

    @Override
    public void nextPage() {
        startActivity( new Intent( this, Setting3Activity.class));
        finish();
        overridePendingTransition( R.anim.tran_in, R.anim.tran_out);
    }

    public  void nextClick(View view)
    {
        nextPage();
    }

    public  void preClick( View view)
    {
        prePage();

    }



}
