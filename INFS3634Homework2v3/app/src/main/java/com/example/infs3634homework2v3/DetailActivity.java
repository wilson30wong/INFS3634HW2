package com.example.infs3634homework2v3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class DetailActivity extends AppCompatActivity {

    private int quantity = 0;
    private String quantityDisplay = "";
    private int itemMenuID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("Borger Kong");

        Intent intent1 = getIntent();
        itemMenuID = intent1.getIntExtra("itemMenuID", 0);
        ItemMenu itemMenuObject = ItemMenuList.getItemMenuByID(itemMenuID);
        ConstraintLayout activity_detail = findViewById(R.id.activity_detail);
        TextView itemMenuName = activity_detail.findViewById(R.id.itemMenuName2);
        itemMenuName.setText(itemMenuObject.getItemMenuName());
        ImageView itemMenuImage = activity_detail.findViewById(R.id.itemMenuImage2);
        itemMenuImage.setImageResource(itemMenuObject.getItemMenuImage());
        TextView itemMenuPrice = activity_detail.findViewById(R.id.itemMenuPrice);
        String itemMenuPriceString = "$" + Double.toString(itemMenuObject.getItemMenuPrice()) + "0";
        itemMenuPrice.setText(itemMenuPriceString);
        TextView itemMenuDescription = activity_detail.findViewById(R.id.itemMenuDescription);
        itemMenuDescription.setText(itemMenuObject.getItemMenuDescription());
        final TextView itemMenuQuantity = activity_detail.findViewById(R.id.itemMenuQuantity);

        Button plusButton = activity_detail.findViewById(R.id.plusButton);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++quantity;
                quantityDisplay = Integer.toString(quantity);
                itemMenuQuantity.setText(quantityDisplay);
            }
        });
        Button minusButton = activity_detail.findViewById(R.id.minusButton);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity == 0) {
                    return;
                } else {
                    --quantity;
                    quantityDisplay = Integer.toString(quantity);
                    itemMenuQuantity.setText(quantityDisplay);
                }
            }
        });
        Button addButton = activity_detail.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity == 0) {
                    return;
                } else {
                    Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                    intent1.putExtra("itemMenuID", itemMenuID);
                    intent1.putExtra("itemMenuQuantity", quantity);
                    startActivity(intent1);
                }
            }
        });

        ConstraintLayout detailHeader = findViewById(R.id.detailHeader);
        ImageView returnToMenuButton2 = detailHeader.findViewById(R.id.returnToMenuButton2);
        returnToMenuButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
