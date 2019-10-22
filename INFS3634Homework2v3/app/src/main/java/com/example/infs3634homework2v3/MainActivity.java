package com.example.infs3634homework2v3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<ItemMenu> itemOrderArray = new ArrayList<ItemMenu>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Borger Kong");

        RecyclerView recyclerView = findViewById(R.id.rv_menu);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MenuAdapter menuAdapter = new MenuAdapter();
        menuAdapter.setData(ItemMenuList.getAllItemMenus());
        recyclerView.setAdapter(menuAdapter);

        Intent intent1 = getIntent();
        int returnFromOrders = intent1.getIntExtra("returnFromOrders", 0);
        if (returnFromOrders == 1) {
            itemOrderArray.clear();
        } else if (returnFromOrders == 2) {
            itemOrderArray = (ArrayList<ItemMenu>) getIntent().getSerializableExtra("itemOrderArray");
        }

        int itemMenuID = intent1.getIntExtra("itemMenuID", 0);
        if (itemMenuID != 0) {
            ItemMenu itemMenuObject = new ItemMenu(itemMenuID);
            int itemMenuQuantity = intent1.getIntExtra("itemMenuQuantity", 0);
            itemMenuObject.setItemOrderQuantity(itemMenuQuantity);
            itemOrderArray.add(itemMenuObject);
        }

        Button viewOrderButton = findViewById(R.id.viewOrderButton);
        viewOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), OrderActivity.class);
                intent2.putExtra("itemOrderArray", itemOrderArray);
                startActivity(intent2);
            }
        });
    }
}
