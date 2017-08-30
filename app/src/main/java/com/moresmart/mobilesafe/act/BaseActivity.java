package com.moresmart.mobilesafe.act;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * @author <youxiaolong@moresmart.com>
 * @version V1.0.0
 * @file BaseActivity.java
 * @brief < description function>
 * @date 2017-08-30 10:35
 * <p>
 * <p>
 * Copyright (C) 2017 MoreSmart Technology Co., Ltd.
 * <p>
 * The program is not free, MoreSmart without permission,
 * no one shall be arbitrarily (including but not limited
 * to: copy, to the illegal way of communication, display,
 * mirror, upload, download) use, or by unconventional
 * methods (such as: malicious intervention MoreSmart data)
 * Moresmart's normal service, no one shall be arbitrarily by
 * software the program automatically get MoreSmart data
 * Otherwise, MoreSmart will be investigated for legal responsibility
 * according to law.
 */

public abstract  class BaseActivity extends Activity {
    private GestureDetector detector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        detector = new GestureDetector( this,new GestureDetector.SimpleOnGestureListener()
        {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                if( ( e1.getRawX() - e2.getRawX()) > 200 ) {
                    System.out.println("99999999999999999");
                    prePage();
                    return true;
                }
                if(  ( e2.getRawX() - e1.getRawX()) > 200 ) {
                    System.out.println("888888888");
                    nextPage();
                    return true;
                }
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        }
        );


    }

    public abstract void prePage();
    public abstract void nextPage();

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        detector.onTouchEvent( event );
        return super.onTouchEvent(event);
    }
}
