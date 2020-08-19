package com.example.quaternion_calculator.ui.features;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.quaternion_calculator.R;

public class FeaturesFragment extends Fragment {

    private EditText s, x, y, z;
    private ImageButton confirm;
    private TextView real_part, x_imaginary_part, y_imaginary_part, z_imaginary_part,  open_bracket, closed_bracket, conjugate, norm, reciprocal;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_features, container, false);

        init(root);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Read quaternion
                // TODO
            }
        });

        return root;
    }

    private void init(View root) {
        // Edit Texts for Quaternion
        s = root. findViewById(R.id.s_features);
        x = root.findViewById(R.id.x_features);
        y = root.findViewById(R.id.y_features);
        z = root.findViewById(R.id.z_features);

        // Confirm-Button
        confirm = root.findViewById(R.id.btn_enter_features);

        // TextViews
        real_part = root.findViewById(R.id.real_part_features);
        x_imaginary_part = root.findViewById(R.id.x_imaginary_part_features);
        y_imaginary_part = root.findViewById(R.id.y_imaginary_part_features);
        z_imaginary_part = root.findViewById(R.id.z_imaginary_part_features);
        open_bracket = root.findViewById(R.id.openbracket_features);
        closed_bracket = root.findViewById(R.id.closedbracket_features);
        conjugate = root.findViewById(R.id.conjugate_features);
        norm = root.findViewById(R.id.norm_features);
        reciprocal = root.findViewById(R.id.reciprocal_features);

        // Set brackets unvisible
        open_bracket.setVisibility(View.GONE);
        closed_bracket.setVisibility(View.GONE);
    }
}
