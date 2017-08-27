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
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.moresmart.mobilesafe.R;
import com.moresmart.mobilesafe.utils.MD5util;

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
                        showPasswordDialog();
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
        // 判断是否设置密码
        String savedPassword = mPref.getString("password", null);
        if (!TextUtils.isEmpty(savedPassword)) {
            // 输入密码弹窗
            showPasswordInputDialog();
        } else {
            // 如果没有设置过, 弹出设置密码的弹窗
            showPasswordSetDialog();
        }
    }

    protected void showPasswordInputDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder( HomeActivity.this);

        final AlertDialog alertDialog =  builder.create();

        View view = View.inflate( HomeActivity.this, R.layout.dailog_input_password, null );

        final EditText password_editText = (EditText) view.findViewById( R.id.et_password);

        Button btn_ok = (Button) view.findViewById(R.id.btn_ok);
        Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password = password_editText.getText().toString().trim();

                if( !TextUtils.isEmpty(password) )
                {
                    String savePassword = mPref.getString("password",null);
                    if( MD5util.encode(password).equals(savePassword))
                    {
                        Toast.makeText( HomeActivity.this,"登入成功", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                        startActivity( new Intent(HomeActivity.this,LostFindActivity.class));
                    }
                    else
                    {
                        Toast.makeText( HomeActivity.this,"密码不正确", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText( HomeActivity.this,"密码为空", Toast.LENGTH_SHORT).show();
                }

            }
        });
        alertDialog.setView( view, 0, 0, 0, 0 );

        alertDialog.show();
    }
    protected void showPasswordSetDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder( HomeActivity.this);

        final AlertDialog alertDialog =  builder.create();

       View view = View.inflate( HomeActivity.this, R.layout.dailog_set_password, null );

        final EditText password_editText = (EditText) view.findViewById( R.id.et_password);
        final EditText confpassword_editText = (EditText) view.findViewById( R.id.et_password_confirm);


        Button btn_ok = (Button) view.findViewById(R.id.btn_ok);
        Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password = password_editText.getText().toString().trim();
                String conPassword = confpassword_editText.getText().toString().trim();

                if( !TextUtils.isEmpty(password) && !(TextUtils.isEmpty(conPassword)))
                {
                    if( password.equals(conPassword))
                    {
                        mPref.edit().putString("password", MD5util.encode(password)).commit();

                        Toast.makeText( HomeActivity.this,"密码已设置", Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();
                    }
                    else {
                        Toast.makeText( HomeActivity.this,"密码不正确", Toast.LENGTH_LONG).show();
                    }

                }
                else
                {
                    Toast.makeText( HomeActivity.this,"密码为空", Toast.LENGTH_LONG).show();
                }

            }
        });
        alertDialog.setView( view, 0, 0, 0, 0 );

        alertDialog.show();


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
