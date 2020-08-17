package com.example.quaternion_calculator.ui.elementary_arithmetic;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.quaternion_calculator.R;

public class ElementaryArithmeticFragment extends Fragment {

    private EditText s_1, x_1, y_1, z_1, s_2, x_2, y_2, z_2;
    private Button plus, minus, times, division, equal;
    private TextView s_result, x_result, y_result, z_result;
    private Drawable selected, deselected;

    private char selectedOperation = ' ';

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_elementary_arithmetic, container, false);

        init(root);

        // Mark selected button of elementary operation
        plus.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                // Select "+" button
                select(plus);
                selectedOperation = '+';

                // Deselect other operation-buttons
                deselect(minus);
                deselect(times);
                deselect(division);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                // Select "-" button
                select(minus);
                selectedOperation = '-';

                // Deselect other operation-buttons
                deselect(plus);
                deselect(times);
                deselect(division);
            }
        });

        times.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                // Select "*" button
                select(times);
                selectedOperation = '*';

                // Deselect other operation-buttons
                deselect(plus);
                deselect(minus);
                deselect(division);
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                // Select "/" button
                select(division);
                selectedOperation = '/';

                // Deselect other operation-buttons
                deselect(plus);
                deselect(minus);
                deselect(times);
            }
        });

        return root;
    }

    /*
    Deselect a button by changing its background and text color
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void deselect(Button btn) {
        btn.setBackground(deselected);
        btn.setTextColor(Color.WHITE);
    }

    /*
    Select a button by changing its background and text color
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void select(Button btn) {
        btn.setBackground(selected);
        btn.setTextColor(Color.BLACK);
    }

    private void init(View root) {

        // First quaternion
        s_1 = root.findViewById(R.id.s_elementary_arithmetic);
        x_1 = root.findViewById(R.id.x_elementary_arithmetic);
        y_1 = root.findViewById(R.id.y_elementary_arithmetic);
        z_1 = root.findViewById(R.id.z_elementary_arithmetic);

        // Second quaternion
        s_2 = root.findViewById(R.id.s_elementary_arithmetic2);
        x_2 = root.findViewById(R.id.x_elementary_arithmetic2);
        y_2 = root.findViewById(R.id.y_elementary_arithmetic2);
        z_2 = root.findViewById(R.id.z_elementary_arithmetic2);

        // Elementary operations
        plus = root.findViewById(R.id.btn_plus_elementary_arithmetic);
        minus = root.findViewById(R.id.btn_minus_elementary_arithmetic);
        times = root.findViewById(R.id.btn_times_elementary_arithmetic);
        division = root.findViewById(R.id.btn_division_elementary_arithmetic);

        // Equal button
        equal = root.findViewById(R.id.btn_equals_elementary_arithmetic);

        // Result quaternion
        s_result = root.findViewById(R.id.s_elementary_arithmetic3);
        x_result = root.findViewById(R.id.x_elementary_arithmetic3);
        y_result = root.findViewById(R.id.y_elementary_arithmetic3);
        z_result = root.findViewById(R.id.z_elementary_arithmetic3);

        // Backgrounds
        deselected = ContextCompat.getDrawable(this.getActivity(), R.drawable.border_button_deselected);
        selected = ContextCompat.getDrawable(this.getActivity(), R.drawable.border_button_selected);
    }
}
