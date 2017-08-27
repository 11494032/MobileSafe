package com.moresmart.mobilesafe.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/8/27.
 */

public class MD5util {

    public static String encode( String password )
    {
        try {

            MessageDigest messageDigest = MessageDigest.getInstance( "MD5");
            byte buf[] = messageDigest.digest( password.getBytes());
            StringBuffer sb = new StringBuffer();
            for( byte b: buf)
            {
                int i = b & 0xff;
                String hexString = Integer.toHexString(i);

                if( hexString.length() < 2 )
                {
                    hexString = "0"+hexString;
                }

                sb.append(hexString);


            }

            return sb.toString();


        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        return "";
    }

}
