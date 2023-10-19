package kbkm.th2023.limbonganready.objects;

public class Events {
    int gambar;
    String judul;

    public Events(int gambar,String judul) {
        this.gambar = gambar;
        this.judul = judul;
    }

    public int getGambar() {
        return gambar;
    }

    public String getJudul(){
        return judul;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
    public  void setJudul(String judul) {
        this.judul = judul;
    }
}