package com.example.quaternion_calculator.ui.features;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.quaternion_calculator.R;
import com.example.quaternion_calculator.quaternions.Quaternion;

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
                // Check for emptiness -> if this is the case enter 0.0 in the box
                // Save the values
                double s_value, x_value, y_value, z_value;

                if (s.getText().toString().isEmpty()) {
                    s.setText("0.0");
                    s_value = 0;
                } else
                    s_value = Double.parseDouble(s.getText().toString());

                if (x.getText().toString().isEmpty()) {
                    x.setText("0.0");
                    x_value = 0;
                } else
                    x_value = Double.parseDouble(x.getText().toString());

                if (y.getText().toString().isEmpty()) {
                    y.setText("0.0");
                    y_value = 0;
                } else
                    y_value = Double.parseDouble(y.getText().toString());

                if (z.getText().toString().isEmpty()) {
                    z.setText("0.0");
                    z_value = 0;
                } else
                    z_value = Double.parseDouble(z.getText().toString());

                // Create Quaternion
                Quaternion q = new Quaternion(s_value, x_value, y_value, z_value);

                // Set brackets to visible
                open_bracket.setVisibility(View.VISIBLE);
                closed_bracket.setVisibility(View.VISIBLE);

                // Real part
                real_part.setText(s_value + "");

                // Imaginary part
                x_imaginary_part.setText(x_value + "");
                y_imaginary_part.setText(y_value + "");
                z_imaginary_part.setText(z_value + "");

                // Conjuate
                conjugate.setText(q.conjugate().toString());

                // Norm
                norm.setText(roundHelper(q.norm(), 5) + "");

                // Reciprocal
                Quaternion r = q.reciprocal();
                r.setS(roundHelper(r.getS(), 2));
                r.setX(roundHelper(r.getX(), 2));
                r.setY(roundHelper(r.getY(), 2));
                r.setZ(roundHelper(r.getZ(), 2));
                reciprocal.setText(r.toString());
            }
        });

        return root;
    }

    /**
     * @param value Value to be rounded
     * @param decimalPlaces number of decimal places
     * @return rounded value
     */
    private double roundHelper(double value, int decimalPlaces){
        double t = Math.pow(10, decimalPlaces);
        return Math.round(value*t) / t;
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

        // Univisible brackets
        open_bracket.setVisibility(View.GONE);
        closed_bracket.setVisibility(View.GONE);
    }
}
