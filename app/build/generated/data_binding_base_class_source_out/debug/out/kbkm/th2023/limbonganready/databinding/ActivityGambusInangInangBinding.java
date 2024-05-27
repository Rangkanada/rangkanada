// Generated by view binder compiler. Do not edit!
package kbkm.th2023.limbonganready.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import kbkm.th2023.limbonganready.R;

public final class ActivityGambusInangInangBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView Komunitas;

  @NonNull
  public final FloatingActionButton backButton;

  @NonNull
  public final MaterialCardView button3DI;

  @NonNull
  public final MaterialCardView buttonGameI;

  @NonNull
  public final MaterialCardView buttonVGambus;

  @NonNull
  public final ImageView event;

  @NonNull
  public final TextView historyContentTextView;

  @NonNull
  public final TextView historyTextView;

  @NonNull
  public final ImageView musik;

  private ActivityGambusInangInangBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView Komunitas, @NonNull FloatingActionButton backButton,
      @NonNull MaterialCardView button3DI, @NonNull MaterialCardView buttonGameI,
      @NonNull MaterialCardView buttonVGambus, @NonNull ImageView event,
      @NonNull TextView historyContentTextView, @NonNull TextView historyTextView,
      @NonNull ImageView musik) {
    this.rootView = rootView;
    this.Komunitas = Komunitas;
    this.backButton = backButton;
    this.button3DI = button3DI;
    this.buttonGameI = buttonGameI;
    this.buttonVGambus = buttonVGambus;
    this.event = event;
    this.historyContentTextView = historyContentTextView;
    this.historyTextView = historyTextView;
    this.musik = musik;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityGambusInangInangBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityGambusInangInangBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_gambus_inang_inang, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityGambusInangInangBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Komunitas;
      ImageView Komunitas = ViewBindings.findChildViewById(rootView, id);
      if (Komunitas == null) {
        break missingId;
      }

      id = R.id.backButton;
      FloatingActionButton backButton = ViewBindings.findChildViewById(rootView, id);
      if (backButton == null) {
        break missingId;
      }

      id = R.id.button3DI;
      MaterialCardView button3DI = ViewBindings.findChildViewById(rootView, id);
      if (button3DI == null) {
        break missingId;
      }

      id = R.id.buttonGameI;
      MaterialCardView buttonGameI = ViewBindings.findChildViewById(rootView, id);
      if (buttonGameI == null) {
        break missingId;
      }

      id = R.id.buttonVGambus;
      MaterialCardView buttonVGambus = ViewBindings.findChildViewById(rootView, id);
      if (buttonVGambus == null) {
        break missingId;
      }

      id = R.id.event;
      ImageView event = ViewBindings.findChildViewById(rootView, id);
      if (event == null) {
        break missingId;
      }

      id = R.id.historyContentTextView;
      TextView historyContentTextView = ViewBindings.findChildViewById(rootView, id);
      if (historyContentTextView == null) {
        break missingId;
      }

      id = R.id.historyTextView;
      TextView historyTextView = ViewBindings.findChildViewById(rootView, id);
      if (historyTextView == null) {
        break missingId;
      }

      id = R.id.musik;
      ImageView musik = ViewBindings.findChildViewById(rootView, id);
      if (musik == null) {
        break missingId;
      }

      return new ActivityGambusInangInangBinding((LinearLayout) rootView, Komunitas, backButton,
          button3DI, buttonGameI, buttonVGambus, event, historyContentTextView, historyTextView,
          musik);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
