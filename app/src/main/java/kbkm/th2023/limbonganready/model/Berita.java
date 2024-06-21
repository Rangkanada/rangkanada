package kbkm.th2023.limbonganready.model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Berita {
    private int id;
    private String judul;
    private String gambar;
    private String sumber;
    private String linkberita;
    private Date createdAt;
    private Date updatedAt;

    public Berita(int id, String judul, String gambar, String sumber, String linkberita, String createdAt, String updatedAt) {
        this.id = id;
        this.judul = judul;
        this.gambar = gambar;
        this.sumber = sumber;
        this.linkberita = linkberita;
        this.createdAt = parseDate(createdAt);
        this.updatedAt = parseDate(updatedAt);
    }

    private Date parseDate(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getSumber() {
        return sumber;
    }

    public void setSumber(String sumber) {
        this.sumber = sumber;
    }

    public String getLinkberita() {
        return linkberita;
    }

    public void setLinkberita(String linkberita) {
        this.linkberita = linkberita;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Berita{" +
                "id=" + id +
                ", judul='" + judul + '\'' +
                ", gambar='" + gambar + '\'' +
                ", sumber='" + sumber + '\'' +
                ", linkberita='" + linkberita + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}