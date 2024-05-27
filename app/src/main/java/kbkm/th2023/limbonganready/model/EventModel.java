package kbkm.th2023.limbonganready.model;



import org.json.JSONException;
import org.json.JSONObject;

public class EventModel {
    private int id;
    private String nama_event;
    private String deskripsi;
    private String tanggal;
    private String lokasi;
    private String image;
    private String coordinate;
    private String created_at;
    private String updated_at;

    public EventModel(int id, String nama_event, String deskripsi, String tanggal, String lokasi, String image, String coordinate, String created_at, String updated_at) {
        this.id = id;
        this.nama_event = nama_event;
        this.deskripsi = deskripsi;
        this.tanggal = tanggal;
        this.lokasi = lokasi;
        this.image = image;
        this.coordinate = coordinate;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getNama_event() {
        return nama_event;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNama_event(String nama_event) {
        this.nama_event = nama_event;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    // Method to convert EventModel object to JSON object
    public JSONObject getCoordinateJSONObject() {
        try {
            return new JSONObject(coordinate);
        } catch (JSONException e) {
            e.printStackTrace();
            return null; // Atau kembalikan nilai default sesuai kebutuhan
        }
    }
}
