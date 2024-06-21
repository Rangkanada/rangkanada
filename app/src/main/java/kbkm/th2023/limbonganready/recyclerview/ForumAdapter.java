package kbkm.th2023.limbonganready.recyclerview;

import static android.app.ProgressDialog.show;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import kbkm.th2023.limbonganready.fragments.ForumListFragment;
import kbkm.th2023.limbonganready.fragments.KoleksiEventFragment;
import kbkm.th2023.limbonganready.model.ForumModel;
import kbkm.th2023.limbonganready.model.ForumResponse;
import kbkm.th2023.limbonganready.model.ForumSayaModel;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ForumViewHolder> {

    private List<ForumModel> forumList;
    private PreferenceManager preferenceManager;
    private ApiService apiService;
    private Set<Integer> userForumSet = new HashSet<>();  // Untuk menyimpan ID forum yang diikuti oleh user
    private ForumListFragment fragment;



    private Set<Integer> userForumKoleksi = new HashSet<>();
    public ForumAdapter(List<ForumModel> forumList, Context context, ForumListFragment fragment) {
        this.forumList = forumList;
        this.preferenceManager = new PreferenceManager(context);
        this.apiService = RetrofitClient.getClient().create(ApiService.class);
        cekSemuaForumUser(context);  // Cek keanggotaan forum sekali saat adapter dibuat
        cekSemuaKoleksiForum(context);
        this.fragment = fragment;
    }

    public void clear() {
        if (forumList != null) {
            forumList.clear();
            notifyDataSetChanged();
        } else {
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public ForumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forum_list, parent, false);
        return new ForumViewHolder(view, preferenceManager, apiService);
    }

    @Override
    public void onBindViewHolder(@NonNull ForumViewHolder holder, int position) {
        ForumModel forum = forumList.get(position);
        holder.bind(forum, userForumSet, userForumKoleksi);
    }

    @Override
    public int getItemCount() {
        return forumList != null ? forumList.size() : 0;
    }

    public void setForumList(List<ForumModel> forumList) {
        this.forumList = forumList;
    }

    private void cekSemuaForumUser(Context context) {
        int userId = preferenceManager.getUserId();
        String token = "Bearer " + preferenceManager.getUserToken();

        Call<List<ForumSayaModel>> call = apiService.getForumSaya(token, userId);
        call.enqueue(new Callback<List<ForumSayaModel>>() {
            @Override
            public void onResponse(Call<List<ForumSayaModel>> call, Response<List<ForumSayaModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<ForumSayaModel> forumSayaList = response.body();
                    for (ForumSayaModel forumSaya : forumSayaList) {
                        userForumSet.add(forumSaya.getForumId());
                    }
                    notifyDataSetChanged();  // Update tampilan setelah data diterima
                }
            }

            @Override
            public void onFailure(Call<List<ForumSayaModel>> call, Throwable t) {
                Toast.makeText(context, "Gagal memuat data forum", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cekSemuaKoleksiForum(Context context){
        int userId = preferenceManager.getUserId();
        String token = "Bearer " + preferenceManager.getUserToken();

        Call<List<ForumResponse>> call = apiService.getKoleksiForum(token, userId);
        call.enqueue(new Callback<List<ForumResponse>>() {
            @Override
            public void onResponse(Call<List<ForumResponse>> call, Response<List<ForumResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<ForumResponse> forumResponseList = response.body();
                    for (ForumResponse forumResponse : forumResponseList) {
                        userForumKoleksi.add(forumResponse.getForumId());

                    }
                    notifyDataSetChanged();  // Update tampilan setelah data diterima
                }
            }

            @Override
            public void onFailure(Call<List<ForumResponse>> call, Throwable t) {
                Toast.makeText(context, "Gagal memuat data forum", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class ForumViewHolder extends RecyclerView.ViewHolder {
        private TextView forumName;
        private TextView forumDescription;
        private TextView totalAnggota;
        private Button tombolGabung;

        private ApiService apiService;
        private PreferenceManager preferenceManager;

        private ImageView tombolBintang;

        public ForumViewHolder(@NonNull View itemView, PreferenceManager preferenceManager, ApiService apiService) {
            super(itemView);
            this.preferenceManager = preferenceManager;
            this.apiService = apiService;
            forumName = itemView.findViewById(R.id.namaForum);
            forumDescription = itemView.findViewById(R.id.deskripsiForum);
            totalAnggota = itemView.findViewById(R.id.totalUser);
            tombolGabung = itemView.findViewById(R.id.tombolGabung);
            tombolBintang = itemView.findViewById(R.id.tombolBintangForum);
        }

        public void bind(ForumModel forum, Set<Integer> userForumSet, Set<Integer> userForumKoleksi) {
            int forumId = forum.getId();
            int userId = preferenceManager.getUserId();
            String token = "Bearer " + preferenceManager.getUserToken();

            String titlee = forum.getNama_forum();
            String descriptione = forum.getDeskripsi();

            tombolGabung.setTag(forumId);

            tombolGabung.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buttonText = tombolGabung.getText().toString();
                    if (buttonText.equalsIgnoreCase("Gabung")) {
                        joinForum(itemView.getContext(), token, forumId, userId);
                    } else if (buttonText.equalsIgnoreCase("Keluar")) {
                        keluarForum(itemView.getContext(), token, forumId, userId);
                    }
                }
            });




            forumName.setText(forum.getNama_forum());
            forumDescription.setText(forum.getDeskripsi());
            totalAnggota.setText("Total Anggota : " + forum.getUser_forum_count());
            if(userForumKoleksi.contains(forumId)){
                tombolBintang.setImageResource(android.R.drawable.btn_star_big_on);
                tombolBintang.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hapusKoleksi(itemView.getContext(), token, forumId, userId);
                    }
                });

            } else {
                tombolBintang.setImageResource(android.R.drawable.btn_star_big_off);
                tombolBintang.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tambahKoleksi(itemView.getContext(), token, forumId, userId, titlee, descriptione);
                    }
                });
            }



            if (userForumSet.contains(forumId)) {
                ubahKeKeluar(tombolGabung);
            } else {
                ubahKeGabung(tombolGabung);
            }

        }

        private void tambahKoleksi(Context context, String token, int forumId, int userId, String title, String description){
            Call<Void> call = apiService.tambahkoleksiforum(token, forumId, userId, title, description);

            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(context, "Berhasil Menambahkan Koleksi", Toast.LENGTH_SHORT).show();
//                        ubahKeKeluar(tombolGabung);
                        fragment.refresh();
                    } else {
                        Toast.makeText(context, "Terjadi kesalahan saat menyimpan data", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(context, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();
                }
            });
        }
        private void hapusKoleksi(Context context, String token, int forumId, int userId){
            Call<Void> call = apiService.hapusKoleksiForum(token, forumId, userId);

            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(context, "Berhasil Menghapus Koleksi", Toast.LENGTH_SHORT).show();
//                        ubahKeKeluar(tombolGabung);
                        fragment.refresh();
                    } else {
                        Toast.makeText(context, "Terjadi kesalahan saat menyimpan data", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(context, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();
                }
            });
        }

        private void joinForum(Context context, String token, int forumId, int userId) {
            Call<Void> call = apiService.masukForum(token, userId, forumId);

            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(context, "Berhasil Bergabung Forum", Toast.LENGTH_SHORT).show();
                        ubahKeKeluar(tombolGabung);
                    } else {
                        Toast.makeText(context, "Terjadi kesalahan saat menyimpan data", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(context, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();
                }
            });
        }

        private void keluarForum(Context context, String token, int forumId, int userId) {
            Call<Void> call = apiService.keluarForum(token, forumId, userId);

            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(context, "Berhasil Keluar dari Forum", Toast.LENGTH_SHORT).show();
                        ubahKeGabung(tombolGabung);
                    } else {
                        Toast.makeText(context, "Terjadi kesalahan saat keluar dari forum", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(context, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();
                }
            });
        }

        private void ubahKeKeluar(Button button) {
            button.setBackgroundColor(Color.parseColor("#D79170"));  // Ubah warna latar belakang ke #D79170
            button.setText("Keluar");
        }

        private void ubahKeGabung(Button button) {
            button.setBackgroundColor(Color.parseColor("#7B3F23"));  // Ubah warna latar belakang ke #7B3F23
            button.setText("Gabung");
        }
    }
}
