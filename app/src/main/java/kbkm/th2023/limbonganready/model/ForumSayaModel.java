package kbkm.th2023.limbonganready.model;

public class ForumSayaModel {
    private int forum_id;
    private String nama_forum;
    private String deskripsi;
    private int total_anggota;

    public ForumSayaModel(int forum_id, String nama_forum, String deskripsi, int total_anggota) {
        this.forum_id = forum_id;
        this.nama_forum = nama_forum;
        this.deskripsi = deskripsi;
        this.total_anggota = total_anggota;
    }

    public int getForumId() {
        return forum_id;
    }

    public void setForumId(int forumId) {
        this.forum_id = forum_id;
    }

    public String getNamaForum() {
        return nama_forum;
    }

    public void setNamaForum(String namaForum) {
        this.nama_forum = namaForum;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getTotalAnggota() {
        return total_anggota;
    }

    public void setTotalAnggota(int totalAnggota) {
        this.total_anggota = totalAnggota;
    }
}
