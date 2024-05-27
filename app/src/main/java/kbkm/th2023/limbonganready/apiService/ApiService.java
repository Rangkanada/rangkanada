package kbkm.th2023.limbonganready.apiService;
import java.util.List;

import kbkm.th2023.limbonganready.model.EventModel;
import kbkm.th2023.limbonganready.model.MusicModel;
import kbkm.th2023.limbonganready.model.UserInfo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("getUserInfo/{iduser}")
    Call<UserInfo> getUserInfo(@Path("iduser") int iduser, @Header("Authorization") String token);


    @FormUrlEncoded
    @POST("daftar")
    Call<Void> daftar(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("password_confirmation") String passwordConfirmation
    );

    @FormUrlEncoded
    @POST("tambahUserInfo")
    Call<Void>tambahUserInfo(
            @Field("user_id") int user_id,
            @Field("nama") String nama,
            @Field("alamat") String alamat,
            @Field("jenis_kelamin") String jenis_kelamin,
            @Field("no_telepon") String no_telepon
    );

//    Event
//    Ambil Event
@GET("getEvent")
Call<List<EventModel>> getEvent(@Header("Authorization") String token);

@FormUrlEncoded
@POST("tambahkoleksievent")
Call<Void>tambahkoleksievent
        (
                @Header("Authorization") String token,
                @Field("event_id") int event_id,
                @Field("user_id") int user_id,
                @Field("title") String title,
                @Field("description") String description
                                  );


    @GET("getKoleksiPerEvent/{event_id}/{user_id}")
    Call<ResponseBody> getKoleksiPerEvent(@Header("Authorization") String token, @Path("event_id") int event_id, @Path("user_id"
    ) int user_id);
    //hapus koleksi event
    @DELETE("hapuskoleksievent/{event_id}/{userid}")
    Call<Void> hapuskoleksievent(@Header("Authorization") String token, @Path("event_id") int event_id, @Path("userid"
    ) int userid);


    //Musik
    @GET("getMusic")
    Call<List<MusicModel>> getMusic(@Header("Authorization") String token);

}
