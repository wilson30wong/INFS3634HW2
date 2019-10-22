package com.example.infs3634homework2v3;

import java.io.Serializable;

public class ItemMenu implements Serializable {

    private int itemMenuID;
    private int itemMenuImage;
    private String itemMenuName;
    private double itemMenuPrice;
    private String itemMenuDescription;
    private int itemOrderQuantity;

    public ItemMenu(int itemMenuID) {
        this.itemMenuID = ItemMenuList.getItemMenuByID(itemMenuID).getItemMenuID();
        this.itemMenuImage = ItemMenuList.getItemMenuByID(itemMenuID).getItemMenuImage();
        this.itemMenuName = ItemMenuList.getItemMenuByID(itemMenuID).getItemMenuName();
        this.itemMenuPrice = ItemMenuList.getItemMenuByID(itemMenuID).getItemMenuPrice();
        this.itemMenuDescription = ItemMenuList.getItemMenuByID(itemMenuID).getItemMenuDescription();
        this.itemOrderQuantity = ItemMenuList.getItemMenuByID(itemMenuID).getItemOrderQuantity();
    }

    public ItemMenu(int itemMenuID, int itemMenuImage, String itemMenuName, double itemMenuPrice, String itemMenuDescription, int itemOrderQuantity) {
        this.itemMenuID = itemMenuID;
        this.itemMenuImage = itemMenuImage;
        this.itemMenuName = itemMenuName;
        this.itemMenuPrice = itemMenuPrice;
        this.itemMenuDescription = itemMenuDescription;
        this.itemOrderQuantity = itemOrderQuantity;
    }

    public int getItemMenuID() {
        return itemMenuID;
    }

    public void setItemMenuID(int itemMenuID) {
        this.itemMenuID = itemMenuID;
    }

    public int getItemMenuImage() {
        return itemMenuImage;
    }

    public void setItemMenuImage(int itemMenuImage) {
        this.itemMenuImage = itemMenuImage;
    }

    public String getItemMenuName() {
        return itemMenuName;
    }

    public void setItemMenuName(String itemMenuName) {
        this.itemMenuName = itemMenuName;
    }

    public double getItemMenuPrice() {
        return itemMenuPrice;
    }

    public void setItemMenuPrice(double itemMenuPrice) {
        this.itemMenuPrice = itemMenuPrice;
    }

    public String getItemMenuDescription() {
        return itemMenuDescription;
    }

    public void setItemMenuDescription(String itemMenuDescription) {
        this.itemMenuDescription = itemMenuDescription;
    }

    public int getItemOrderQuantity() {
        return itemOrderQuantity;
    }

    public void setItemOrderQuantity(int itemOrderQuantity) {
        this.itemOrderQuantity = itemOrderQuantity;
    }
}
