// Generated by view binder compiler. Do not edit!
package com.progetto_dd.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.progetto_dd.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class FragmentHomeCharacterBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout homeCharacterFragment;

  private FragmentHomeCharacterBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout homeCharacterFragment) {
    this.rootView = rootView;
    this.homeCharacterFragment = homeCharacterFragment;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeCharacterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeCharacterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home_character, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeCharacterBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    LinearLayout homeCharacterFragment = (LinearLayout) rootView;

    return new FragmentHomeCharacterBinding((LinearLayout) rootView, homeCharacterFragment);
  }
}