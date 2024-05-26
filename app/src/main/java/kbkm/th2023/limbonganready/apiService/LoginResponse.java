package kbkm.th2023.limbonganready.apiService;

import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kbkm.th2023.limbonganready.model.User;

public class LoginResponse {
    @SerializedName("token")
    private String token;

    @SerializedName("message")
    private String message;

    @SerializedName("user")
    private User user;

    public User getUser() {
        return user;
    }
    public String getToken(){
        return  token;
    }

    public String getMessageAsJson() {
        // Membuat objek JSON
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("message", message);
        jsonObject.addProperty("token", token);

        // Mengonversi objek JSON menjadi string JSON
        Gson gson = new Gson();
        return gson.toJson(jsonObject);
    }
}
