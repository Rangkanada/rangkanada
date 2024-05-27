// Generated by view binder compiler. Do not edit!
package kbkm.th2023.limbonganready.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import kbkm.th2023.limbonganready.R;

public final class ActivityTentangDesaBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView historyContentTextView;

  @NonNull
  public final TextView textSub2;

  private ActivityTentangDesaBinding(@NonNull RelativeLayout rootView,
      @NonNull TextView historyContentTextView, @NonNull TextView textSub2) {
    this.rootView = rootView;
    this.historyContentTextView = historyContentTextView;
    this.textSub2 = textSub2;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTentangDesaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTentangDesaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_tentang_desa, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTentangDesaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.historyContentTextView;
      TextView historyContentTextView = ViewBindings.findChildViewById(rootView, id);
      if (historyContentTextView == null) {
        break missingId;
      }

      id = R.id.textSub2;
      TextView textSub2 = ViewBindings.findChildViewById(rootView, id);
      if (textSub2 == null) {
        break missingId;
      }

      return new ActivityTentangDesaBinding((RelativeLayout) rootView, historyContentTextView,
          textSub2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
