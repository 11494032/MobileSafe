package com.moresmart.mobilesafe.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.moresmart.mobilesafe.R;

/**
 * Created by Administrator on 2017/8/27.
 */

public class SettingItemView extends RelativeLayout {

    private TextView tv_title;
    private TextView tv_desc;
    private CheckBox cbStatus;

    //有代码new对象时，走此方法
    public SettingItemView(Context context) {
        super(context);
        initView();
    }

    //有属性的话走此方法
    public SettingItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    //有style样式的话会走此方法
    public SettingItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView()
    {
        //将自定义好的布局文件设置给当前的SettingItemView
        View view = View.inflate(getContext(), R.layout.view_setting_item, this);

        tv_title = (TextView) findViewById( R.id.tv_title);
        tv_desc = (TextView) findViewById( R.id.tv_desc);
        cbStatus = (CheckBox) findViewById( R.id.cb_status );


    }

    public void setTitle( String title) {
       tv_title.setText( title );
    }

    public void setDesc( String title) {
        tv_desc.setText( title );
    }

    public boolean isChecked() {
        return cbStatus.isChecked();

    }
    public  void setChecked( boolean checked)
    {
        cbStatus.setChecked( checked );
    }




}
