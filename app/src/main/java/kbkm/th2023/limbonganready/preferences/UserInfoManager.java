package kbkm.th2023.limbonganready.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class UserInfoManager {
    private static final String PREF_NAME = "UserInfoPrefs";

    private static final String KEY_NAMA = "nama";
    private static final String KEY_ALAMAT = "alamat";
    private static final String KEY_JK = "jeniskelamin";
    private static final String KEY_NO = "notelepon";

    private SharedPreferences userInfoPrefs;
    private SharedPreferences.Editor editor;

    public UserInfoManager(Context context) {
        userInfoPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = userInfoPrefs.edit();
    }

    // Metode untuk menyimpan nama ke SharedPreferences
    public void setNama(String nama) {
        editor.putString(KEY_NAMA, nama);
        editor.apply();
    }
    public void clear() {
        editor.clear();
        editor.apply();
    }
    // Metode untuk menyimpan alamat ke SharedPreferences
    public void setAlamat(String alamat) {
        editor.putString(KEY_ALAMAT, alamat);
        editor.apply();
    }

    // Metode untuk menyimpan jenis kelamin ke SharedPreferences
    public void setJenisKelamin(String jenisKelamin) {
        editor.putString(KEY_JK, jenisKelamin);
        editor.apply();
    }

    // Metode untuk menyimpan nomor telepon ke SharedPreferences
    public void setNomorTelepon(String nomorTelepon) {
        editor.putString(KEY_NO, nomorTelepon);
        editor.apply();
    }

    // Metode untuk mendapatkan nama dari SharedPreferences
    public String getNama() {
        return userInfoPrefs.getString(KEY_NAMA, "");
    }

    // Metode untuk mendapatkan alamat dari SharedPreferences
    public String getAlamat() {
        return userInfoPrefs.getString(KEY_ALAMAT, "");
    }

    // Metode untuk mendapatkan jenis kelamin dari SharedPreferences
    public String getJenisKelamin() {
        return userInfoPrefs.getString(KEY_JK, "");
    }

    // Metode untuk mendapatkan nomor telepon dari SharedPreferences
    public String getNomorTelepon() {
        return userInfoPrefs.getString(KEY_NO, "");
    }
}
