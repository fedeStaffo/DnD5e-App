// Generated by view binder compiler. Do not edit!
package com.progetto_dd.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.progetto_dd.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentClassBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnAvanti;

  @NonNull
  public final Button btnIndietro;

  @NonNull
  public final Button infoBardo;

  @NonNull
  public final Button infoChierico;

  @NonNull
  public final Button infoGuerriero;

  @NonNull
  public final Button infoLadro;

  @NonNull
  public final Button infoMago;

  @NonNull
  public final Button infoPaladino;

  @NonNull
  public final Button scegliBardo;

  @NonNull
  public final Button scegliChierico;

  @NonNull
  public final Button scegliGuerriero;

  @NonNull
  public final Button scegliLadro;

  @NonNull
  public final Button scegliMago;

  @NonNull
  public final Button scegliPaladino;

  private FragmentClassBinding(@NonNull LinearLayout rootView, @NonNull Button btnAvanti,
      @NonNull Button btnIndietro, @NonNull Button infoBardo, @NonNull Button infoChierico,
      @NonNull Button infoGuerriero, @NonNull Button infoLadro, @NonNull Button infoMago,
      @NonNull Button infoPaladino, @NonNull Button scegliBardo, @NonNull Button scegliChierico,
      @NonNull Button scegliGuerriero, @NonNull Button scegliLadro, @NonNull Button scegliMago,
      @NonNull Button scegliPaladino) {
    this.rootView = rootView;
    this.btnAvanti = btnAvanti;
    this.btnIndietro = btnIndietro;
    this.infoBardo = infoBardo;
    this.infoChierico = infoChierico;
    this.infoGuerriero = infoGuerriero;
    this.infoLadro = infoLadro;
    this.infoMago = infoMago;
    this.infoPaladino = infoPaladino;
    this.scegliBardo = scegliBardo;
    this.scegliChierico = scegliChierico;
    this.scegliGuerriero = scegliGuerriero;
    this.scegliLadro = scegliLadro;
    this.scegliMago = scegliMago;
    this.scegliPaladino = scegliPaladino;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentClassBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentClassBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_class, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentClassBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_avanti;
      Button btnAvanti = ViewBindings.findChildViewById(rootView, id);
      if (btnAvanti == null) {
        break missingId;
      }

      id = R.id.btn_indietro;
      Button btnIndietro = ViewBindings.findChildViewById(rootView, id);
      if (btnIndietro == null) {
        break missingId;
      }

      id = R.id.info_bardo;
      Button infoBardo = ViewBindings.findChildViewById(rootView, id);
      if (infoBardo == null) {
        break missingId;
      }

      id = R.id.info_chierico;
      Button infoChierico = ViewBindings.findChildViewById(rootView, id);
      if (infoChierico == null) {
        break missingId;
      }

      id = R.id.info_guerriero;
      Button infoGuerriero = ViewBindings.findChildViewById(rootView, id);
      if (infoGuerriero == null) {
        break missingId;
      }

      id = R.id.info_ladro;
      Button infoLadro = ViewBindings.findChildViewById(rootView, id);
      if (infoLadro == null) {
        break missingId;
      }

      id = R.id.info_mago;
      Button infoMago = ViewBindings.findChildViewById(rootView, id);
      if (infoMago == null) {
        break missingId;
      }

      id = R.id.info_paladino;
      Button infoPaladino = ViewBindings.findChildViewById(rootView, id);
      if (infoPaladino == null) {
        break missingId;
      }

      id = R.id.scegli_bardo;
      Button scegliBardo = ViewBindings.findChildViewById(rootView, id);
      if (scegliBardo == null) {
        break missingId;
      }

      id = R.id.scegli_chierico;
      Button scegliChierico = ViewBindings.findChildViewById(rootView, id);
      if (scegliChierico == null) {
        break missingId;
      }

      id = R.id.scegli_guerriero;
      Button scegliGuerriero = ViewBindings.findChildViewById(rootView, id);
      if (scegliGuerriero == null) {
        break missingId;
      }

      id = R.id.scegli_ladro;
      Button scegliLadro = ViewBindings.findChildViewById(rootView, id);
      if (scegliLadro == null) {
        break missingId;
      }

      id = R.id.scegli_mago;
      Button scegliMago = ViewBindings.findChildViewById(rootView, id);
      if (scegliMago == null) {
        break missingId;
      }

      id = R.id.scegli_paladino;
      Button scegliPaladino = ViewBindings.findChildViewById(rootView, id);
      if (scegliPaladino == null) {
        break missingId;
      }

      return new FragmentClassBinding((LinearLayout) rootView, btnAvanti, btnIndietro, infoBardo,
          infoChierico, infoGuerriero, infoLadro, infoMago, infoPaladino, scegliBardo,
          scegliChierico, scegliGuerriero, scegliLadro, scegliMago, scegliPaladino);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}