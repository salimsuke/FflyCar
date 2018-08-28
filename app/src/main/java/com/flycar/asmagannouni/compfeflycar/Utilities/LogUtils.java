package com.flycar.asmagannouni.compfeflycar.Utilities;


import com.flycar.asmagannouni.compfeflycar.BuildConfig;

/**
 * @author Hemant M
 *         Created by Hemant M on 08/01/2018.
 */

/*
* LogUtils utility which make sure that logs will not appear on console for release build.
* */
public class LogUtils {

    private static boolean LOG = BuildConfig.DEBUG;

    public static void i(String tag, String string) {
        if (LOG) android.util.Log.i(tag, string);
    }

    public static void e(String tag, String string) {
        if (LOG) android.util.Log.e(tag, string);
    }

    public static void d(String tag, String string) {
        if (LOG) android.util.Log.d(tag, string);
    }

    public static void v(String tag, String string) {
        if (LOG) android.util.Log.v(tag, string);
    }

    public static void w(String tag, String string) {
        if (LOG) android.util.Log.w(tag, string);
    }

    public static void longMessage(String tag, String message) {
        if (LOG) {
            int maxLogSize = 2000;
            for (int i = 0; i <= message.length() / maxLogSize; i++) {
                int start = i * maxLogSize;
                int end = (i + 1) * maxLogSize;
                end = end > message.length() ? message.length() : end;
                android.util.Log.d(tag, message.substring(start, end));
            }
        }
    }
}
