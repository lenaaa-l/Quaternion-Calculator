package com.example.quaternion_calculator.ui.rotation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.quaternion_calculator.R;
import com.example.quaternion_calculator.quaternions.Quaternion;
import com.example.quaternion_calculator.quaternions.QuaternionOperation;

import java.util.Vector;

public class RotationFragment extends Fragment {

    private EditText x_point, y_point, z_point, x_axis, y_axis, z_axis, angle;
    private LinearLayout result;
    private TextView x_new_point, y_new_point, z_new_point;
    private ImageButton confirm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_rotation, container, false);

        init(root);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Result layout visible
                result.setVisibility(View.VISIBLE);

                // Get values
                Quaternion point_quaternion = readPoint();
                Vector<Double> rotation_axis = readAxis();
                double alpha = readAngle();

                if (rotation_axis.get(0) == 0 && rotation_axis.get(1) == 0 && rotation_axis.get(2) == 0) {
                    Toast.makeText(getActivity(), "Rotation axis can't be the zero vector", Toast.LENGTH_SHORT).show();
                } else {

                    // Normalize vector
                    rotation_axis = normalize(rotation_axis);

                    // Calculate result
                    Quaternion result = QuaternionOperation.rotate(point_quaternion, rotation_axis, alpha);

                    // Show result
                    x_new_point.setText("" + roundHelper(result.getX(), 2));
                    y_new_point.setText("" + roundHelper(result.getY(), 2));
                    z_new_point.setText("" + roundHelper(result.getZ(), 2));
                }
            }
        });


        return root;
    }

    /**
     * Normalize a vector by multiplying each element with 1/norm
     *
     * @param rotation_axis vector to be normalized
     * @return normalized vector
     */
    private Vector<Double> normalize(Vector<Double> rotation_axis) {
        double norm = Math.sqrt(Math.pow(rotation_axis.get(0), 2) + Math.pow(rotation_axis.get(1), 2) +
                Math.pow(rotation_axis.get(2), 2));

        Vector<Double> normalized_vector = new Vector<>();
        normalized_vector.add((1 / norm) * rotation_axis.get(0));
        normalized_vector.add((1 / norm) * rotation_axis.get(1));
        normalized_vector.add((1 / norm) * rotation_axis.get(2));

        return normalized_vector;
    }

    /**
     * @param value         Value to be rounded
     * @param decimalPlaces number of decimal places
     * @return rounded value
     */
    private double roundHelper(double value, int decimalPlaces) {
        double t = Math.pow(10, decimalPlaces);
        return Math.round(value * t) / t;
    }

    private double readAngle() {
        double alpha = 0.0;
        if (angle.getText().toString().isEmpty())
            angle.setText("0.0");
        else
            alpha = Double.parseDouble(angle.getText().toString());

        return alpha;
    }

    /**
     * Get the values of the axis (x,y,z)
     * If an edit-text is empty, insert 0
     *
     * @return Vektor (x, y, z)
     */
    private Vector<Double> readAxis() {
        double x_a, y_a, z_a;

        if (x_axis.getText().toString().isEmpty()) {
            x_axis.setText("0.0");
            x_a = 0;
        } else
            x_a = Double.parseDouble(x_axis.getText().toString());

        if (y_axis.getText().toString().isEmpty()) {
            y_axis.setText("0.0");
            y_a = 0;
        } else
            y_a = Double.parseDouble(y_axis.getText().toString());

        if (z_axis.getText().toString().isEmpty()) {
            z_axis.setText("0.0");
            z_a = 0;
        } else
            z_a = Double.parseDouble(z_axis.getText().toString());

        Vector<Double> a = new Vector();
        a.add(x_a);
        a.add(y_a);
        a.add(z_a);

        return a;
    }

    /**
     * Get the values of the point (x,y,z)
     * If an edit-text is empty, insert 0
     *
     * @return new quaternion (0, x, y, z)
     */
    private Quaternion readPoint() {
        double x_p, y_p, z_p;

        if (x_point.getText().toString().isEmpty()) {
            x_point.setText("0.0");
            x_p = 0;
        } else
            x_p = Double.parseDouble(x_point.getText().toString());

        if (y_point.getText().toString().isEmpty()) {
            y_point.setText("0.0");
            y_p = 0;
        } else
            y_p = Double.parseDouble(y_point.getText().toString());

        if (z_point.getText().toString().isEmpty()) {
            z_point.setText("0.0");
            z_p = 0;
        } else
            z_p = Double.parseDouble(z_point.getText().toString());

        // Create Quaternion
        return new Quaternion(0, x_p, y_p, z_p);
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
