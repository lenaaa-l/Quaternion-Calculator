package com.example.quaternion_calculator.ui.rotation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.quaternion_calculator.R;

public class RotationFragment extends Fragment {

    private RotationViewModel rotationViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        rotationViewModel =
                ViewModelProviders.of(this).get(RotationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_rotation, container, false);


        return root;
    }
}
