package com.example.storeit.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeit.R;
import com.example.storeit.models.HomeHorModel;
import com.example.storeit.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;

    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if (check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.mouse_1, "Logitech Pro Light", "399"));
            homeVerModels.add(new HomeVerModel(R.drawable.mouse_2, "Logitech MX Master", "99"));
            homeVerModels.add(new HomeVerModel(R.drawable.mouse_3, "Logitech G502 Hero", "79"));
            homeVerModels.add(new HomeVerModel(R.drawable.mouse_4, "SteelSeries Rival 600", "79"));

            updateVerticalRec.callBack(position, homeVerModels);
            check = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    row_index = position;
                    notifyDataSetChanged();

                    if (position == 0) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.mouse_1, "Logitech Pro Light", "399.90"));
                        homeVerModels.add(new HomeVerModel(R.drawable.mouse_2, "Logitech MX Master", "99.50"));
                        homeVerModels.add(new HomeVerModel(R.drawable.mouse_3, "Logitech G502 Hero", "79"));
                        homeVerModels.add(new HomeVerModel(R.drawable.mouse_4, "SteelSeries Rival 600", "79"));

                        updateVerticalRec.callBack(position, homeVerModels);
                    } else if (position == 1) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.keyboard_1, "Razer BkaclWidow V3", "139"));
                        homeVerModels.add(new HomeVerModel(R.drawable.keyboard_2, "Corsair k95", "199"));
                        homeVerModels.add(new HomeVerModel(R.drawable.keyboard_3, "Ducky one Mini", "99"));
                        updateVerticalRec.callBack(position, homeVerModels);
                    } else if (position == 2) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.headset_1, "Sony WH-1000", "349"));
                        homeVerModels.add(new HomeVerModel(R.drawable.headset_2, "HyperX Pro", "499"));
                        homeVerModels.add(new HomeVerModel(R.drawable.headset_3, "Sony WH-CH710N", "299"));
                        homeVerModels.add(new HomeVerModel(R.drawable.headset_4, "Logitech G PRO X", "199"));
                        homeVerModels.add(new HomeVerModel(R.drawable.headset_5, "Boose earbuds", "299"));
                        updateVerticalRec.callBack(position, homeVerModels);
                    } else if (position == 3) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.graphics_1, "Geforce GTX 1050TI Asus", "990"));
                        homeVerModels.add(new HomeVerModel(R.drawable.graphics_2, "GeForce RTX 3070 ", "899"));
                        homeVerModels.add(new HomeVerModel(R.drawable.graphics_3, "EVGA GeForce RTX 3090", "1999.90"));
                        homeVerModels.add(new HomeVerModel(R.drawable.graphics_4, "Asus GeForce RTX 3080", "1199"));
                        homeVerModels.add(new HomeVerModel(R.drawable.graphics_5, "3090 FTW3 Ultra", "2299"));
                        updateVerticalRec.callBack(position, homeVerModels);
                    } else if (position == 4) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.ram_1, "G.SKILL Trident Z 32GB", "179.99"));
                        homeVerModels.add(new HomeVerModel(R.drawable.ram_2, "HyperX Beast 8gb ", "199.90"));
                        homeVerModels.add(new HomeVerModel(R.drawable.ram_3, "HyperX Fury 8gb", "169.90"));
                        updateVerticalRec.callBack(position, homeVerModels);
                    }
                }
            });
            if (select) {
                if (position == 0) {
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                    select = false;
                }
            } else {
                if (row_index == position) {
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                } else {
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }
            }
        }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
