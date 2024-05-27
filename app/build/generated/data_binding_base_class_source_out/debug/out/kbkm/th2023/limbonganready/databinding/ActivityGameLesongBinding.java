// Generated by view binder compiler. Do not edit!
package kbkm.th2023.limbonganready.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import kbkm.th2023.limbonganready.R;

public final class ActivityGameLesongBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final FloatingActionButton backButton;

  @NonNull
  public final WebView gameLesong;

  private ActivityGameLesongBinding(@NonNull RelativeLayout rootView,
      @NonNull FloatingActionButton backButton, @NonNull WebView gameLesong) {
    this.rootView = rootView;
    this.backButton = backButton;
    this.gameLesong = gameLesong;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityGameLesongBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityGameLesongBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_game_lesong, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityGameLesongBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.backButton;
      FloatingActionButton backButton = ViewBindings.findChildViewById(rootView, id);
      if (backButton == null) {
        break missingId;
      }

      id = R.id.gameLesong;
      WebView gameLesong = ViewBindings.findChildViewById(rootView, id);
      if (gameLesong == null) {
        break missingId;
      }

      return new ActivityGameLesongBinding((RelativeLayout) rootView, backButton, gameLesong);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
