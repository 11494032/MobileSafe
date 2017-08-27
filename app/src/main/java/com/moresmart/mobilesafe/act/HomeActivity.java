package com.moresmart.mobilesafe.act;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.moresmart.mobilesafe.R;

/**
 * @author <11494032@qq.com>
 * @version V1.0.0
 * @file HomeActivity.java
 * @brief < description function>
 * @date 2017-08-26 15:48
*/

public class HomeActivity extends Activity{

    private GridView gvHome;

    private String[] mItems = new String[]{
            "手机防盗", "通讯卫士", "软件管理",
            "进程管理", "流量统计", "手机杀毒",
            "缓存清理", "高级工具", "设置中心" };
    private int[] mPics = new int[]{
            R.drawable.home_safe, R.drawable.home_callmsgsafe, R.drawable.home_apps,
            R.drawable.home_taskmanager, R.drawable.home_netmanager, R.drawable.home_trojan,
            R.drawable.home_sysoptimize, R.drawable.home_tools, R.drawable.home_settings
    };
    private SharedPreferences mPref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_home);

        gvHome = (GridView) findViewById( R.id.gridView);
        gvHome.setAdapter( new HomeAdapt());

        mPref = getSharedPreferences("config", MODE_PRIVATE);

        gvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch( position )
                {
                    case 0:
                       // showPasswordDialog();
                        break;

                    case 8:
                        startActivity(new Intent(HomeActivity.this,SettingActivity.class));
                    default:
                        break;
                }



            }
        });



    }

    protected void showPasswordDialog()
    {
        String savePassword = mPref.getString("password","");
        if( !TextUtils.isEmpty(savePassword) )
        {
            // 输入密码弹窗

            showPasswordInputDialog();

        }
        else
        {

            showPasswordSetDialog();
        }
    }

    protected void showPasswordInputDialog()
    {

    }
    protected void showPasswordSetDialog()
    {

    }
    class HomeAdapt extends BaseAdapter
    {

        @Override
        public int getCount() {
            return mItems.length;
        }

        @Override
        public Object getItem(int i) {
            return mItems[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View contView = View.inflate( HomeActivity.this, R.layout.home_list_item, null);

            ImageView imageView = (ImageView) contView.findViewById( R.id.iv_item);
            TextView textView = (TextView) contView.findViewById( R.id.tv_item);

            imageView.setImageResource( mPics[i]);
            textView.setText( mItems[i]);

            return contView;

        }
    }


}
