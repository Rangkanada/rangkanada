package kbkm.th2023.limbonganready.apiService;
import java.util.List;


import kbkm.th2023.limbonganready.model.Berita;
import kbkm.th2023.limbonganready.model.Chat;
import kbkm.th2023.limbonganready.model.EventDetail;
import kbkm.th2023.limbonganready.model.EventModel;
import kbkm.th2023.limbonganready.model.ForumModel;
import kbkm.th2023.limbonganready.model.ForumResponse;
import kbkm.th2023.limbonganready.model.ForumSayaBuatModel;
import kbkm.th2023.limbonganready.model.ForumSayaModel;
import kbkm.th2023.limbonganready.model.MusicModel;
import kbkm.th2023.limbonganready.model.Notifikasi;
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


    @GET("getForum/{iduser}")
    Call<List<ForumModel>> getForum(@Header("Authorization") String token, @Path("iduser") int iduser);

    @GET("tampilkanForum/{userid}")
    Call<List<ForumSayaModel>> getForumSaya(@Header("Authorization") String token, @Path("userid") int userid);


    @GET("ambilForumKu/{userid}")
    Call<List<ForumSayaBuatModel>> getForumSayaBuat(@Header("Authorization") String token, @Path("userid") int userid);

    @FormUrlEncoded
    @POST("masukForum")
    Call<Void>masukForum
            (
                    @Header("Authorization") String token,
                    @Field("user_id") int user_id,
                    @Field("forum_id") int forum_id
            );

    @DELETE("keluarForum/{id}/{userid}")
    Call<Void> keluarForum(
            @Header("Authorization") String token,
            @Path("id") int id,
            @Path("userid") int userId
    );

//    get chat
@GET("getChatPerForum/{forum_id}")
Call<List<Chat>> getChats(@Header("Authorization") String token, @Path("forum_id") int forum_id);

@FormUrlEncoded
@POST("tambahChat")
Call<Void>tambahChat
            (
                    @Header("Authorization") String token,
                    @Field("user_id") int user_id,
                    @Field("forum_id") int forum_id,
                    @Field("message") String message
            );



//mengambil koleksi event
@GET("getKoleksiEvent/{iduser}")
Call<List<EventDetail>> getKoleksiEvent(@Header("Authorization") String token, @Path("iduser") int iduser) ;




//mengambil koleksi forum

@GET("getKoleksi/{iduser}")
Call<List<ForumResponse>> getKoleksiForum(@Header("Authorization") String token, @Path("iduser") int iduser) ;

//hapus semua forum koleksi
@DELETE("hapussemuakoleksiforum/{iduser}")
    Call<Void> hapusSemuaKoleksiForum(
            @Header("Authorization") String token,
            @Path("iduser") int iduser

    );
//tambah koleksi forum
@FormUrlEncoded
@POST("tambahkoleksiforum")
Call<Void>tambahkoleksiforum
(
        @Header("Authorization") String token,
        @Field("forum_id") int event_id,
        @Field("user_id") int user_id,
        @Field("title") String title,
        @Field("description") String description
);
//hapus per forum
@DELETE("hapuskoleksiforum/{forum_id}/{user_id}")
Call<Void> hapusKoleksiForum(
        @Header("Authorization") String token,
        @Path("forum_id") int forum_id,
        @Path("user_id") int user_id
);

//hapus semua forum event
@DELETE("hapussemuakoleksievent/{iduser}")
    Call<Void> hapusSemuaKoleksiEvent(
            @Header("Authorization") String token,
            @Path("iduser") int iduser

    );

    @DELETE("hapuskoleksievent/{event_id}/{user_id}")
    Call<Void> hapusKoleksiEvent(
            @Header("Authorization") String token,
            @Path("event_id") int event_id,
            @Path("user_id") int user_id
    );


    @GET("getBerita")
    Call<List<Berita>> getBerita(@Header("Authorization") String token
    );

    @GET("getEventBaru")
    Call<List<EventModel>> getEventBaru(@Header("Authorization") String token
    );

    @GET("getnotification")
    Call<List<Notifikasi>> getNotifikasi(@Header("Authorization") String token
    );


//    Logout
    @POST("logout")
    Call<Void> logout(@Header("Authorization") String token);




}
