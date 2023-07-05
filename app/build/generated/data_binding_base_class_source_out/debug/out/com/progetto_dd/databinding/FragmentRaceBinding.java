// Generated by view binder compiler. Do not edit!
package com.progetto_dd.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.progetto_dd.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentRaceBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final Button btnAvanti;

  @NonNull
  public final Button infoDragonide;

  @NonNull
  public final Button infoElfo;

  @NonNull
  public final Button infoGnomo;

  @NonNull
  public final Button infoHalfling;

  @NonNull
  public final Button infoMezzelfo;

  @NonNull
  public final Button infoMezzorco;

  @NonNull
  public final Button infoNano;

  @NonNull
  public final Button infoTiefling;

  @NonNull
  public final Button infoUmano;

  @NonNull
  public final Button scegliDragonide;

  @NonNull
  public final Button scegliElfo;

  @NonNull
  public final Button scegliGnomo;

  @NonNull
  public final Button scegliHalfling;

  @NonNull
  public final Button scegliMezzelfo;

  @NonNull
  public final Button scegliMezzorco;

  @NonNull
  public final Button scegliNano;

  @NonNull
  public final Button scegliTiefling;

  @NonNull
  public final Button scegliUmano;

  private FragmentRaceBinding(@NonNull ScrollView rootView, @NonNull Button btnAvanti,
      @NonNull Button infoDragonide, @NonNull Button infoElfo, @NonNull Button infoGnomo,
      @NonNull Button infoHalfling, @NonNull Button infoMezzelfo, @NonNull Button infoMezzorco,
      @NonNull Button infoNano, @NonNull Button infoTiefling, @NonNull Button infoUmano,
      @NonNull Button scegliDragonide, @NonNull Button scegliElfo, @NonNull Button scegliGnomo,
      @NonNull Button scegliHalfling, @NonNull Button scegliMezzelfo,
      @NonNull Button scegliMezzorco, @NonNull Button scegliNano, @NonNull Button scegliTiefling,
      @NonNull Button scegliUmano) {
    this.rootView = rootView;
    this.btnAvanti = btnAvanti;
    this.infoDragonide = infoDragonide;
    this.infoElfo = infoElfo;
    this.infoGnomo = infoGnomo;
    this.infoHalfling = infoHalfling;
    this.infoMezzelfo = infoMezzelfo;
    this.infoMezzorco = infoMezzorco;
    this.infoNano = infoNano;
    this.infoTiefling = infoTiefling;
    this.infoUmano = infoUmano;
    this.scegliDragonide = scegliDragonide;
    this.scegliElfo = scegliElfo;
    this.scegliGnomo = scegliGnomo;
    this.scegliHalfling = scegliHalfling;
    this.scegliMezzelfo = scegliMezzelfo;
    this.scegliMezzorco = scegliMezzorco;
    this.scegliNano = scegliNano;
    this.scegliTiefling = scegliTiefling;
    this.scegliUmano = scegliUmano;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentRaceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentRaceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_race, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentRaceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_avanti;
      Button btnAvanti = ViewBindings.findChildViewById(rootView, id);
      if (btnAvanti == null) {
        break missingId;
      }

      id = R.id.info_dragonide;
      Button infoDragonide = ViewBindings.findChildViewById(rootView, id);
      if (infoDragonide == null) {
        break missingId;
      }

      id = R.id.info_elfo;
      Button infoElfo = ViewBindings.findChildViewById(rootView, id);
      if (infoElfo == null) {
        break missingId;
      }

      id = R.id.info_gnomo;
      Button infoGnomo = ViewBindings.findChildViewById(rootView, id);
      if (infoGnomo == null) {
        break missingId;
      }

      id = R.id.info_halfling;
      Button infoHalfling = ViewBindings.findChildViewById(rootView, id);
      if (infoHalfling == null) {
        break missingId;
      }

      id = R.id.info_mezzelfo;
      Button infoMezzelfo = ViewBindings.findChildViewById(rootView, id);
      if (infoMezzelfo == null) {
        break missingId;
      }

      id = R.id.info_mezzorco;
      Button infoMezzorco = ViewBindings.findChildViewById(rootView, id);
      if (infoMezzorco == null) {
        break missingId;
      }

      id = R.id.info_nano;
      Button infoNano = ViewBindings.findChildViewById(rootView, id);
      if (infoNano == null) {
        break missingId;
      }

      id = R.id.info_tiefling;
      Button infoTiefling = ViewBindings.findChildViewById(rootView, id);
      if (infoTiefling == null) {
        break missingId;
      }

      id = R.id.info_umano;
      Button infoUmano = ViewBindings.findChildViewById(rootView, id);
      if (infoUmano == null) {
        break missingId;
      }

      id = R.id.scegli_dragonide;
      Button scegliDragonide = ViewBindings.findChildViewById(rootView, id);
      if (scegliDragonide == null) {
        break missingId;
      }

      id = R.id.scegli_elfo;
      Button scegliElfo = ViewBindings.findChildViewById(rootView, id);
      if (scegliElfo == null) {
        break missingId;
      }

      id = R.id.scegli_gnomo;
      Button scegliGnomo = ViewBindings.findChildViewById(rootView, id);
      if (scegliGnomo == null) {
        break missingId;
      }

      id = R.id.scegli_halfling;
      Button scegliHalfling = ViewBindings.findChildViewById(rootView, id);
      if (scegliHalfling == null) {
        break missingId;
      }

      id = R.id.scegli_mezzelfo;
      Button scegliMezzelfo = ViewBindings.findChildViewById(rootView, id);
      if (scegliMezzelfo == null) {
        break missingId;
      }

      id = R.id.scegli_mezzorco;
      Button scegliMezzorco = ViewBindings.findChildViewById(rootView, id);
      if (scegliMezzorco == null) {
        break missingId;
      }

      id = R.id.scegli_nano;
      Button scegliNano = ViewBindings.findChildViewById(rootView, id);
      if (scegliNano == null) {
        break missingId;
      }

      id = R.id.scegli_tiefling;
      Button scegliTiefling = ViewBindings.findChildViewById(rootView, id);
      if (scegliTiefling == null) {
        break missingId;
      }

      id = R.id.scegli_umano;
      Button scegliUmano = ViewBindings.findChildViewById(rootView, id);
      if (scegliUmano == null) {
        break missingId;
      }

      return new FragmentRaceBinding((ScrollView) rootView, btnAvanti, infoDragonide, infoElfo,
          infoGnomo, infoHalfling, infoMezzelfo, infoMezzorco, infoNano, infoTiefling, infoUmano,
          scegliDragonide, scegliElfo, scegliGnomo, scegliHalfling, scegliMezzelfo, scegliMezzorco,
          scegliNano, scegliTiefling, scegliUmano);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}