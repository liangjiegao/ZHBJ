package util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * SharePreference封装
 *
 * Created by gdei on 2018/6/16.
 */

public class PrefUtil {
    private static final String TAG = "PrefUtil";
    private static SharedPreferences sp;

    public static boolean getIsFirstStart(Context context, String key,boolean defValue){
        sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }
    public static void setIsFirstStart(Context context, String key,boolean value){
        sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }
}
