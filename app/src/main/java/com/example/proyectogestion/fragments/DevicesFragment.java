package com.example.proyectogestion.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectogestion.adapters.DeviceAdapter;
import com.example.proyectogestion.databinding.FragmentDevicesBinding;
import com.example.proyectogestion.models.DeviceModel;

import java.util.ArrayList;


public class DevicesFragment extends Fragment {

    private FragmentDevicesBinding binding;

    DeviceAdapter deviceAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    ArrayList<DeviceModel> tablaLocal = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDevicesBinding.inflate(inflater, container, false);
        init();
        initRecycler();
        setListener();
        return binding.getRoot();
    }


    private void init() {
        tablaLocal.add(new DeviceModel("Device 1"));
        tablaLocal.add(new DeviceModel("Device 2"));
        tablaLocal.add(new DeviceModel("Device 3"));
        tablaLocal.add(new DeviceModel("Device 4"));
        tablaLocal.add(new DeviceModel("Device 5"));
        tablaLocal.add(new DeviceModel("Device 6"));
    }

    private void initRecycler() {
        System.out.println("--->initRecycler");

        recyclerView = binding.recyclerView;
        layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        deviceAdapter = new DeviceAdapter(tablaLocal);
        deviceAdapter.OnClick(new DeviceAdapter.onClick() {
            @Override
            public void OnClick(DeviceModel deviceModel, int position) {
                try {
                    Toast.makeText(requireContext(), "Aqui va tu pantalla", Toast.LENGTH_SHORT).show();
                } catch (Exception ex) {
                    Toast.makeText(requireContext(), "ERROR--->", Toast.LENGTH_SHORT).show();
                }
            }
        });
        recyclerView.setAdapter(deviceAdapter);
        deviceAdapter.notifyDataSetChanged();
    }

    private void setListener() {
    }
}