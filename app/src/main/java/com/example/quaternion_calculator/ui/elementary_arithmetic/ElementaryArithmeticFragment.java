package com.example.quaternion_calculator.ui.elementary_arithmetic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.quaternion_calculator.R;

public class ElementaryArithmeticFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_elementary_arithmetic, container, false);

        return root;
    }
}
