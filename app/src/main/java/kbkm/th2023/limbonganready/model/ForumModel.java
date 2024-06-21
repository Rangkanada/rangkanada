package kbkm.th2023.limbonganready.model;

public class ForumModel {
    private int id;
    private int idcreater;
    private String nama_forum;
    private String deskripsi;
    private String tanggal_dibuat;
    private String create_at;
    private String updated_at;
    private int user_forum_count;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcreater() {
        return idcreater;
    }

    public void setIdcreater(int idcreater) {
        this.idcreater = idcreater;
    }

    public String getNama_forum() {
        return nama_forum;
    }

    public void setNama_forum(String nama_forum) {
        this.nama_forum = nama_forum;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTanggal_dibuat() {
        return tanggal_dibuat;
    }

    public void setTanggal_dibuat(String tanggal_dibuat) {
        this.tanggal_dibuat = tanggal_dibuat;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getUser_forum_count() {
        return user_forum_count;
    }

    public void setUser_forum_count(int user_forum_count) {
        this.user_forum_count = user_forum_count;
    }
}
