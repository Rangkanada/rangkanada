// Generated by view binder compiler. Do not edit!
package kbkm.th2023.limbonganready.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import kbkm.th2023.limbonganready.R;

public final class FragmentKoleksiBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView Dkoleksi;

  @NonNull
  public final FloatingActionButton backButton;

  @NonNull
  public final Button btKol1;

  @NonNull
  public final Button btKol2;

  @NonNull
  public final Button btnLogout;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final TextView listsatu;

  @NonNull
  public final TextView tgl;

  private FragmentKoleksiBinding(@NonNull LinearLayout rootView, @NonNull ImageView Dkoleksi,
      @NonNull FloatingActionButton backButton, @NonNull Button btKol1, @NonNull Button btKol2,
      @NonNull Button btnLogout, @NonNull LinearLayout linearLayout2, @NonNull TextView listsatu,
      @NonNull TextView tgl) {
    this.rootView = rootView;
    this.Dkoleksi = Dkoleksi;
    this.backButton = backButton;
    this.btKol1 = btKol1;
    this.btKol2 = btKol2;
    this.btnLogout = btnLogout;
    this.linearLayout2 = linearLayout2;
    this.listsatu = listsatu;
    this.tgl = tgl;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentKoleksiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentKoleksiBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_koleksi, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentKoleksiBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Dkoleksi;
      ImageView Dkoleksi = ViewBindings.findChildViewById(rootView, id);
      if (Dkoleksi == null) {
        break missingId;
      }

      id = R.id.backButton;
      FloatingActionButton backButton = ViewBindings.findChildViewById(rootView, id);
      if (backButton == null) {
        break missingId;
      }

      id = R.id.btKol1;
      Button btKol1 = ViewBindings.findChildViewById(rootView, id);
      if (btKol1 == null) {
        break missingId;
      }

      id = R.id.btKol2;
      Button btKol2 = ViewBindings.findChildViewById(rootView, id);
      if (btKol2 == null) {
        break missingId;
      }

      id = R.id.btn_Logout;
      Button btnLogout = ViewBindings.findChildViewById(rootView, id);
      if (btnLogout == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.listsatu;
      TextView listsatu = ViewBindings.findChildViewById(rootView, id);
      if (listsatu == null) {
        break missingId;
      }

      id = R.id.tgl;
      TextView tgl = ViewBindings.findChildViewById(rootView, id);
      if (tgl == null) {
        break missingId;
      }

      return new FragmentKoleksiBinding((LinearLayout) rootView, Dkoleksi, backButton, btKol1,
          btKol2, btnLogout, linearLayout2, listsatu, tgl);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}