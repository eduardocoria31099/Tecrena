package com.example.proyectogestion.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectogestion.models.ManualModel;
import com.example.proyectogestion.R;

import java.util.ArrayList;

public class ManualAdapter extends RecyclerView.Adapter<ManualAdapter.ViewHolder> {

    private onClick onClick;

    public interface onClick {
        void OnClick(ManualModel manualModel, int position);
    }

    public void OnClick(onClick onClick) {
        this.onClick = onClick;
    }


    private ArrayList<ManualModel> manualModels;
    private ManualModel _manualModels;

    public ManualAdapter(ArrayList<ManualModel> manualModels) {
        this.manualModels = manualModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manuals, parent, false);
        return new ViewHolder(view, onClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String name = manualModels.get(position).getName();

        ManualModel manualModel = manualModels.get(position);
        _manualModels = manualModel;

        holder.setData(name);
    }

    @Override
    public int getItemCount() {
        return manualModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView _name;
        private ImageView _img;
        private CardView _cv;


        public ViewHolder(@NonNull View itemView, onClick onClick) {
            super(itemView);

            _name = itemView.findViewById(R.id.tvNameDevice);
            _img = itemView.findViewById(R.id.imgDevice);
            _cv = itemView.findViewById(R.id.cvDevice);

            _cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClick != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                        onClick.OnClick(_manualModels, getAdapterPosition());
                    }
                }
            });
        }

        public void setData(String name) {
            _name.setText(name);
            _img.setImageResource(R.drawable.baseline_book);
        }
    }
}
