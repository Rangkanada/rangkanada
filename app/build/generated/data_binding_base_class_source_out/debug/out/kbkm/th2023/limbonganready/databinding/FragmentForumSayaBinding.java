// Generated by view binder compiler. Do not edit!
package kbkm.th2023.limbonganready.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import kbkm.th2023.limbonganready.R;

public final class FragmentForumSayaBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final RecyclerView recyclerForumIkuti;

  @NonNull
  public final RecyclerView recyclerSayaBuat;

  @NonNull
  public final TextView textForumSaya;

  @NonNull
  public final TextView textView2;

  private FragmentForumSayaBinding(@NonNull FrameLayout rootView,
      @NonNull RecyclerView recyclerForumIkuti, @NonNull RecyclerView recyclerSayaBuat,
      @NonNull TextView textForumSaya, @NonNull TextView textView2) {
    this.rootView = rootView;
    this.recyclerForumIkuti = recyclerForumIkuti;
    this.recyclerSayaBuat = recyclerSayaBuat;
    this.textForumSaya = textForumSaya;
    this.textView2 = textView2;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentForumSayaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentForumSayaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_forum_saya, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentForumSayaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.recyclerForumIkuti;
      RecyclerView recyclerForumIkuti = ViewBindings.findChildViewById(rootView, id);
      if (recyclerForumIkuti == null) {
        break missingId;
      }

      id = R.id.recyclerSayaBuat;
      RecyclerView recyclerSayaBuat = ViewBindings.findChildViewById(rootView, id);
      if (recyclerSayaBuat == null) {
        break missingId;
      }

      id = R.id.textForumSaya;
      TextView textForumSaya = ViewBindings.findChildViewById(rootView, id);
      if (textForumSaya == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      return new FragmentForumSayaBinding((FrameLayout) rootView, recyclerForumIkuti,
          recyclerSayaBuat, textForumSaya, textView2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
