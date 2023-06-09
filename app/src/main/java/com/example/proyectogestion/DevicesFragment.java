package com.example.proyectogestion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.proyectogestion.databinding.FragmentDevicesBinding;


public class DevicesFragment extends Fragment {

    private FragmentDevicesBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDevicesBinding.inflate(inflater, container, false);
        init();
        setListener();
        return binding.getRoot();
    }

    private void setListener() {
    }

    private void init() {

    }
}