package com.github.rajeev02.androidnotificationlibrary;

import android.content.Context;
import android.content.Intent;

/**
 * Created by rajeev on 12/22/17.
 */

public class AppConstant {
    public static final String YES_ACTION = "YES_ACTION";
    public static final String STOP_ACTION = "STOP_ACTION";
    public static final String MAYBE_ACTION = "MAYBE_ACTION";

    static Context mContext;
    static String title ,message;
    static Intent intent;

    public static Context getmContext() {
        return mContext;
    }

    public static void setmContext(Context mContext) {
        AppConstant.mContext = mContext;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        AppConstant.title = title;
    }

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        AppConstant.message = message;
    }

    public static Intent getIntent() {
        return intent;
    }

    public static void setIntent(Intent intent) {
        AppConstant.intent = intent;
    }
}
