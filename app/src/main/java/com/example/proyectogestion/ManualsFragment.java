package com.example.proyectogestion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.proyectogestion.databinding.FragmentManualsBinding;


public class ManualsFragment extends Fragment {

    private FragmentManualsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentManualsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}