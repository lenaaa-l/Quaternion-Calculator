package com.example.quaternion_calculator.ui.rotation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.quaternion_calculator.R;

public class RotationFragment extends Fragment {

    private EditText x_point, y_point, z_point, x_axis, y_axis, z_axis, angle;
    private LinearLayout result;
    private TextView x_new_point, y_new_point, z_new_point;
    private ImageButton confirm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_rotation, container, false);

        init(root);


        return root;
    }

    private void init(View root) {
        // Input point
        x_point = root.findViewById(R.id.x_point_rotation);
        y_point = root.findViewById(R.id.y_point_rotation);
        z_point = root.findViewById(R.id.z_point_rotation);

        // Input axis
        x_axis = root.findViewById(R.id.x_rotation_axis);
        y_axis = root.findViewById(R.id.y_rotation_axis);
        z_axis = root.findViewById(R.id.z_rotation_axis);

        // Input angle
        angle = root.findViewById(R.id.angle_rotation);

        // Result point
        x_new_point = root.findViewById(R.id.x2_point_rotation);
        y_new_point = root.findViewById(R.id.y2_point_rotation);
        z_new_point = root.findViewById(R.id.z2_point_rotation);

        // Linear layout
        result = root.findViewById(R.id.layout_new_point_rotation);
        result.setVisibility(View.GONE);

        // Confirm button
        confirm = root.findViewById(R.id.btn_enter_rotation);
    }
}
