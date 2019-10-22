package com.example.infs3634homework2v3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private ArrayList<ItemMenu> itemOrderArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        getSupportActionBar().setTitle("Borger Kong");

        itemOrderArray = (ArrayList<ItemMenu>) getIntent().getSerializableExtra("itemOrderArray");

        RecyclerView recyclerView = findViewById(R.id.rv_order);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        OrderAdapter orderAdapter = new OrderAdapter();
        orderAdapter.setData(itemOrderArray);
        recyclerView.setAdapter(orderAdapter);

        ConstraintLayout activity_order_footer = findViewById(R.id.orderFooter);
        TextView totalText = activity_order_footer.findViewById(R.id.totalText);
        String orderTotal = "Total: $" + Double.toString(orderAdapter.getOrderTotal()) + "0";
        totalText.setText(orderTotal);

        ConstraintLayout activity_order_header = findViewById(R.id.orderHeader);
        ImageView returnToMenuButton = activity_order_header.findViewById(R.id.returnToMenuButton);
        returnToMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                intent1.putExtra("returnFromOrders", 2);
                intent1.putExtra("itemOrderArray", itemOrderArray);
                OrderAdapter.setOrderTotal(0);
                startActivity(intent1);
            }
        });

    }

}
