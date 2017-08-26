package com.moresmart.mobilesafe.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * @author <11494032@qq.com>
 * @version V1.0.0
 * @file VersionUtil.java
 * @brief < description function>
 * @date 2017-08-26 15:29
*/

public class VersionUtil {

    /**
     * @brief 获取版本名称
     * @param context
     * @return
     */
    public static String getVersionName( Context context )
    {
        PackageManager packageManager = context.getPackageManager();

        try {
            PackageInfo packageInfo = packageManager.getPackageInfo( context.getPackageName(),0);

            int versionCode = packageInfo.versionCode;
            String versionName = packageInfo.versionName;

            System.out.println("versionName=" + versionName + ";versionCode=" + versionCode);

            return versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * @brief 获取本地app的版本号
     * @param context
     * @return
     */


    public static int getVersionCode( Context context )
    {

        PackageManager packageManager = context.getPackageManager();

        try {
            PackageInfo packageInfo = packageManager.getPackageInfo( context.getPackageName(),0);

            int versionCode = packageInfo.versionCode;

            return versionCode;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return 0;
    }


}
