package Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class MutePreferences {

    private SharedPreferences prefs;
    private static String PREFERENCES_NAME = "MutePreferences";
    public static String USUARIO_LOGUEADO = "USUARIO_LOGUEADO";

    public MutePreferences(Context ctx){
        prefs = ctx.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
    }

    public String getString(String key, String default_) {
        return prefs.getString(key,default_);
    }

    public void setString(String key, String value){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key,value);
        editor.apply();
    }

}
