package com.example.infs3634homework2v3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private ArrayList<ItemMenu> ItemOrderArray;

    public static void setOrderTotal(double orderTotal) {
        OrderAdapter.orderTotal = orderTotal;
    }

    public static double orderTotal = 0;

    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        OrderViewHolder orderViewHolder = new OrderViewHolder(view);
        return orderViewHolder;
    }

    public void onBindViewHolder(@NonNull final OrderViewHolder holder, final int position) {
        ItemMenu itemMenuObject = ItemOrderArray.get(position);
        final Context context = holder.itemMenuName3.getContext();
        holder.itemMenuImage3.setImageResource(itemMenuObject.getItemMenuImage());
        holder.itemMenuName3.setText(itemMenuObject.getItemMenuName());
        String itemMenuOrderQuantityString = "x" + Integer.toString(itemMenuObject.getItemOrderQuantity());
        holder.itemMenuQuantity2.setText(itemMenuOrderQuantityString);
        holder.removeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1;
                ItemOrderArray.remove(position);
                if (getItemCount() == 0) {
                    intent1 = new Intent(context, MainActivity.class);
                    intent1.putExtra("returnFromOrders", 1);
                } else {
                    intent1 = new Intent(context, OrderActivity.class);
                    intent1.putExtra("itemOrderArray", ItemOrderArray);
                }
                orderTotal = 0;
                context.startActivity(intent1);
            }
        });
    }

    public int getItemCount() {
        return ItemOrderArray.size();
    }

    public void setData(ArrayList<ItemMenu> data) {
        this.ItemOrderArray = data;
    }

    public double getOrderTotal() {
        for (int i = 0; i < ItemOrderArray.size(); i++) {
            ItemMenu itemMenuObject = ItemOrderArray.get(i);
            orderTotal += (itemMenuObject.getItemOrderQuantity() * itemMenuObject.getItemMenuPrice());
        }
        return orderTotal;
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView itemMenuImage3;
        public TextView itemMenuName3;
        public TextView itemMenuQuantity2;
        public Button removeOrderButton;

        public OrderViewHolder(View v) {
            super(v);
            view = v;
            itemMenuImage3 = v.findViewById(R.id.itemMenuImage3);
            itemMenuName3 = v.findViewById(R.id.itemMenuName3);
            itemMenuQuantity2 = v.findViewById(R.id.itemMenuQuantity2);
            removeOrderButton = v.findViewById(R.id.removeOrderButton);
        }
    }


}
