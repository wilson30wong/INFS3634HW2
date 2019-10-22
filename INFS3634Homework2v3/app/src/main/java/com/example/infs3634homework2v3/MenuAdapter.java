package com.example.infs3634homework2v3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private ArrayList<ItemMenu> ItemMenuArray;

    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        MenuViewHolder menuViewHolder = new MenuViewHolder(view);
        return menuViewHolder;
    }

    public void onBindViewHolder(@NonNull final MenuViewHolder holder, final int position) {
        ItemMenu itemMenuObject = ItemMenuArray.get(position);
        final Context context = holder.itemMenuName.getContext();
        holder.itemMenuImage.setImageResource(itemMenuObject.getItemMenuImage());
        holder.itemMenuName.setText(itemMenuObject.getItemMenuName());
        String itemMenuPriceString = "$" + Double.toString(itemMenuObject.getItemMenuPrice()) + "0";
        holder.itemMenuPrice2.setText(itemMenuPriceString);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, DetailActivity.class);
                intent1.putExtra("itemMenuID", position + 1);
                context.startActivity(intent1);
            }
        });
    }

    public int getItemCount() {
        return ItemMenuArray.size();
    }

    public void setData(ArrayList<ItemMenu> data) {
        this.ItemMenuArray = data;
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView itemMenuImage;
        public TextView itemMenuName;
        public TextView itemMenuPrice2;

        public MenuViewHolder(View v) {
            super(v);
            view = v;
            itemMenuImage = v.findViewById(R.id.itemMenuImage);
            itemMenuName = v.findViewById(R.id.itemMenuName);
            itemMenuPrice2 = v.findViewById(R.id.itemMenuPrice2);
        }
    }

}