// Generated by view binder compiler. Do not edit!
package kbkm.th2023.limbonganready.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import kbkm.th2023.limbonganready.R;

public final class FragmentProfileBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView Dkoleksi;

  @NonNull
  public final AppCompatImageView appCompatImageView;

  @NonNull
  public final AppCompatImageView appCompatImageView2;

  @NonNull
  public final FloatingActionButton backButton;

  @NonNull
  public final ImageButton btSetting;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final TextView listsatu;

  @NonNull
  public final TextView namapengguna;

  @NonNull
  public final TextView textemail;

  private FragmentProfileBinding(@NonNull LinearLayout rootView, @NonNull ImageView Dkoleksi,
      @NonNull AppCompatImageView appCompatImageView,
      @NonNull AppCompatImageView appCompatImageView2, @NonNull FloatingActionButton backButton,
      @NonNull ImageButton btSetting, @NonNull ImageView imageView2,
      @NonNull LinearLayout linearLayout, @NonNull TextView listsatu,
      @NonNull TextView namapengguna, @NonNull TextView textemail) {
    this.rootView = rootView;
    this.Dkoleksi = Dkoleksi;
    this.appCompatImageView = appCompatImageView;
    this.appCompatImageView2 = appCompatImageView2;
    this.backButton = backButton;
    this.btSetting = btSetting;
    this.imageView2 = imageView2;
    this.linearLayout = linearLayout;
    this.listsatu = listsatu;
    this.namapengguna = namapengguna;
    this.textemail = textemail;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Dkoleksi;
      ImageView Dkoleksi = ViewBindings.findChildViewById(rootView, id);
      if (Dkoleksi == null) {
        break missingId;
      }

      id = R.id.appCompatImageView;
      AppCompatImageView appCompatImageView = ViewBindings.findChildViewById(rootView, id);
      if (appCompatImageView == null) {
        break missingId;
      }

      id = R.id.appCompatImageView2;
      AppCompatImageView appCompatImageView2 = ViewBindings.findChildViewById(rootView, id);
      if (appCompatImageView2 == null) {
        break missingId;
      }

      id = R.id.backButton;
      FloatingActionButton backButton = ViewBindings.findChildViewById(rootView, id);
      if (backButton == null) {
        break missingId;
      }

      id = R.id.bt_setting;
      ImageButton btSetting = ViewBindings.findChildViewById(rootView, id);
      if (btSetting == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.listsatu;
      TextView listsatu = ViewBindings.findChildViewById(rootView, id);
      if (listsatu == null) {
        break missingId;
      }

      id = R.id.namapengguna;
      TextView namapengguna = ViewBindings.findChildViewById(rootView, id);
      if (namapengguna == null) {
        break missingId;
      }

      id = R.id.textemail;
      TextView textemail = ViewBindings.findChildViewById(rootView, id);
      if (textemail == null) {
        break missingId;
      }

      return new FragmentProfileBinding((LinearLayout) rootView, Dkoleksi, appCompatImageView,
          appCompatImageView2, backButton, btSetting, imageView2, linearLayout, listsatu,
          namapengguna, textemail);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
