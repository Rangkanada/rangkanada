package kbkm.th2023.limbonganready.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    private static final String PREF_NAME = "MyPrefs";
    private static final String KEY_ID = "userId";
    private static final String KEY_TOKEN = "userToken";
    private static final String KEY_EMAIL = "userEmail";
    private static final String KEY_NAME = "userName";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public PreferenceManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    // Metode untuk menyimpan ID ke SharedPreferences
    public void saveUserId(int userId) {
        editor.putInt(KEY_ID, userId);
        editor.apply();
    }

    // Metode untuk menyimpan token ke SharedPreferences
    public void saveUserToken(String userToken) {
        editor.putString(KEY_TOKEN, userToken);
        editor.apply();
    }

    // Metode untuk menyimpan email ke SharedPreferences
    public void saveUserEmail(String userEmail) {
        editor.putString(KEY_EMAIL, userEmail);
        editor.apply();
    }

    // Metode untuk menyimpan nama ke SharedPreferences
    public void saveUserName(String userName) {
        editor.putString(KEY_NAME, userName);
        editor.apply();
    }

    // Metode untuk mendapatkan ID dari SharedPreferences
    public int getUserId() {
        return sharedPreferences.getInt(KEY_ID, -1); // -1 adalah nilai default jika tidak ada ID yang tersimpan
    }

    // Metode untuk mendapatkan token dari SharedPreferences
    public String getUserToken() {
        return sharedPreferences.getString(KEY_TOKEN, ""); // "" adalah nilai default jika tidak ada token yang tersimpan
    }
    public String getUserEmail() {
        return sharedPreferences.getString(KEY_EMAIL, ""); // "" adalah nilai default jika tidak ada email yang tersimpan
    }

    // Metode untuk mendapatkan nama dari SharedPreferences
    public String getUserName() {
        return sharedPreferences.getString(KEY_NAME, ""); // "" adalah nilai default jika tidak ada nama yang tersimpan
    }
}
