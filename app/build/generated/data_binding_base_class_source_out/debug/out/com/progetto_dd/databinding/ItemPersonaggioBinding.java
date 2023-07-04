// Generated by view binder compiler. Do not edit!
package com.progetto_dd.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.progetto_dd.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemPersonaggioBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView listapClasse;

  @NonNull
  public final TextView listapNome;

  @NonNull
  public final TextView listapRazza;

  private ItemPersonaggioBinding(@NonNull CardView rootView, @NonNull TextView listapClasse,
      @NonNull TextView listapNome, @NonNull TextView listapRazza) {
    this.rootView = rootView;
    this.listapClasse = listapClasse;
    this.listapNome = listapNome;
    this.listapRazza = listapRazza;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemPersonaggioBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemPersonaggioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_personaggio, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemPersonaggioBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.listap_classe;
      TextView listapClasse = ViewBindings.findChildViewById(rootView, id);
      if (listapClasse == null) {
        break missingId;
      }

      id = R.id.listap_nome;
      TextView listapNome = ViewBindings.findChildViewById(rootView, id);
      if (listapNome == null) {
        break missingId;
      }

      id = R.id.listap_razza;
      TextView listapRazza = ViewBindings.findChildViewById(rootView, id);
      if (listapRazza == null) {
        break missingId;
      }

      return new ItemPersonaggioBinding((CardView) rootView, listapClasse, listapNome, listapRazza);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
