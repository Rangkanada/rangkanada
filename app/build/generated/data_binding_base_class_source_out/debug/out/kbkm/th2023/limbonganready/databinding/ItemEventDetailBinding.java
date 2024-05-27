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
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import kbkm.th2023.limbonganready.R;

public final class ItemEventDetailBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView ImageEvent;

  @NonNull
  public final TextView JudulEvent;

  @NonNull
  public final TextView textViewDate;

  @NonNull
  public final TextView textViewTempat;

  private ItemEventDetailBinding(@NonNull LinearLayout rootView, @NonNull ImageView ImageEvent,
      @NonNull TextView JudulEvent, @NonNull TextView textViewDate,
      @NonNull TextView textViewTempat) {
    this.rootView = rootView;
    this.ImageEvent = ImageEvent;
    this.JudulEvent = JudulEvent;
    this.textViewDate = textViewDate;
    this.textViewTempat = textViewTempat;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemEventDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemEventDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_event_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemEventDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ImageEvent;
      ImageView ImageEvent = ViewBindings.findChildViewById(rootView, id);
      if (ImageEvent == null) {
        break missingId;
      }

      id = R.id.JudulEvent;
      TextView JudulEvent = ViewBindings.findChildViewById(rootView, id);
      if (JudulEvent == null) {
        break missingId;
      }

      id = R.id.textViewDate;
      TextView textViewDate = ViewBindings.findChildViewById(rootView, id);
      if (textViewDate == null) {
        break missingId;
      }

      id = R.id.textViewTempat;
      TextView textViewTempat = ViewBindings.findChildViewById(rootView, id);
      if (textViewTempat == null) {
        break missingId;
      }

      return new ItemEventDetailBinding((LinearLayout) rootView, ImageEvent, JudulEvent,
          textViewDate, textViewTempat);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
