package kbkm.th2023.limbonganready.objects;

public class Events {
    int gambar;
    String judul;
    String tanggal;
    String lokasi;

    public Events(int gambar,String judul,String tanggal,String lokasi) {
        this.gambar = gambar;
        this.judul = judul;
        this.tanggal = tanggal;
        this.lokasi = lokasi;
    }

    public int getGambar() {
        return gambar;
    }

    public String getJudul(){
        return judul;
    }

    public String getTanggal(){
        return tanggal;
    }

    public String getLokasi(){
        return lokasi;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
    public  void setJudul(String judul) {
        this.judul = judul;
    }
    public  void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public  void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}