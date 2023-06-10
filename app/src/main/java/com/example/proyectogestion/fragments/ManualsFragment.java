package com.example.proyectogestion.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectogestion.models.ManualModel;
import com.example.proyectogestion.adapters.ManualAdapter;
import com.example.proyectogestion.databinding.FragmentManualsBinding;

import java.util.ArrayList;


public class ManualsFragment extends Fragment {

    private FragmentManualsBinding binding;

    ManualAdapter manualAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    ArrayList<ManualModel> tablaLocal = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentManualsBinding.inflate(inflater, container, false);
        initLocalTable();
        initRecycler();
        return binding.getRoot();
    }

    private void initLocalTable() {
        tablaLocal.add(new ManualModel("Manual 1"));
        tablaLocal.add(new ManualModel("Manual 2"));
        tablaLocal.add(new ManualModel("Manual 3"));

    }

    private void initRecycler() {
        System.out.println("--->initRecycler");

        recyclerView = binding.recyclerView;
        layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        manualAdapter = new ManualAdapter(tablaLocal);
        manualAdapter.OnClick(new ManualAdapter.onClick() {
            @Override
            public void OnClick(ManualModel manualModel, int position) {
                try {
                    Toast.makeText(requireContext(), "Aqui va tu pantalla", Toast.LENGTH_SHORT).show();
                } catch (Exception ex) {
                    Toast.makeText(requireContext(), "ERROR--->", Toast.LENGTH_SHORT).show();
                }
            }
        });
        recyclerView.setAdapter(manualAdapter);
        manualAdapter.notifyDataSetChanged();
    }
}