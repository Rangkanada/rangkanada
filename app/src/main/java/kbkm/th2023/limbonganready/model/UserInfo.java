package kbkm.th2023.limbonganready.model;

public class UserInfo {
    private String nama;
    private String alamat;
    private String jenis_kelamin;
    private String no_telepon;
    // Constructor
    public UserInfo(String nama, String alamat, String jenis_kelamin, String no_telepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.jenis_kelamin = jenis_kelamin;
        this.no_telepon = no_telepon;
    }

    // Getter dan setter untuk nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter dan setter untuk alamat
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    // Getter dan setter untuk jenis kelamin
    public String getJenisKelamin() {
        return jenis_kelamin;
    }

    public void setJenisKelamin(String jeniskelamin) {
        this.jenis_kelamin = jeniskelamin;
    }

    // Getter dan setter untuk nomor telepon
    public String getNomorTelepon() {
        return no_telepon;
    }

    public void setNomorTelepon(String notelepon) {
        this.no_telepon = notelepon;
    }


}
