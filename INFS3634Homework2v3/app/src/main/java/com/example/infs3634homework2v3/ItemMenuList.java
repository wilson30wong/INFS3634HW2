package com.example.infs3634homework2v3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ItemMenuList {

    public static ItemMenu getItemMenuByID(int itemMenuID) {
        return itemMenus.get(itemMenuID);
    }

    public static ArrayList<ItemMenu> getAllItemMenus() {
        return new ArrayList<ItemMenu>((List) Arrays.asList(itemMenus.values().toArray()));
    }

    private static final HashMap<Integer, ItemMenu> itemMenus = new HashMap<>();

    static {
        itemMenus.put(1, new ItemMenu(
                1,
                R.drawable.burger,
                "Cheese Burger",
                5.00,
                "A burger with a beef patty, cheese and tomato sauce",
                0
        ));
        itemMenus.put(2, new ItemMenu(
                2,
                R.drawable.burger,
                "Chicken Burger",
                5.00,
                "A burger with a chicken fillet, lettuce, tomato and mayo",
                0
        ));
        itemMenus.put(3, new ItemMenu(
                3,
                R.drawable.burger,
                "Fish Burger",
                5.00,
                "A burger with a fish fillet and tartar sauce",
                0
        ));
        itemMenus.put(4, new ItemMenu(
                4,
                R.drawable.burger,
                "Vegetarian Burger",
                5.00,
                "A burger with tofu patty, lettuce, tomato and mayo",
                0
        ));
        itemMenus.put(5, new ItemMenu(
                5,
                R.drawable.wrap,
                "Chicken Wrap",
                5.00,
                "A wrap with chicken, lettuce, tomato and mayo",
                0
        ));
        itemMenus.put(6, new ItemMenu(
                6,
                R.drawable.wrap,
                "Vegetarian Wrap",
                5.00,
                "A wrap with tofu, lettuce, tomato and mayo",
                0
        ));
        itemMenus.put(7, new ItemMenu(
                7,
                R.drawable.salad,
                "Chicken Salad",
                5.00,
                "A salad with chicken, leaves, spinach, tomato and ranch dressing",
                0
        ));
        itemMenus.put(8, new ItemMenu(
                8,
                R.drawable.salad,
                "Greek Salad",
                5.00,
                "A salad with cheese, leaves, spinach, tomato and balsamic vinegar",
                0
        ));
        itemMenus.put(9, new ItemMenu(
                9,
                R.drawable.chips,
                "Chips",
                2.50,
                "Chips serving for one person",
                0
        ));
        itemMenus.put(10, new ItemMenu(
                10,
                R.drawable.onion_rings,
                "Onion Rings",
                2.50,
                "Onion rings serving for one person",
                0
        ));
        itemMenus.put(11, new ItemMenu(
                11,
                R.drawable.drink,
                "Sprite",
                2.50,
                "375mL can of Sprite",
                0
        ));
        itemMenus.put(12, new ItemMenu(
                12,
                R.drawable.drink,
                "Coke",
                2.50,
                "375mL can of Coke",
                0
        ));
        itemMenus.put(13, new ItemMenu(
                12,
                R.drawable.drink,
                "Fanta",
                2.50,
                "375mL can of Fanta",
                0
        ));
        itemMenus.put(14, new ItemMenu(
                14,
                R.drawable.drink,
                "Vanilla Milkshake",
                2.50,
                "500mL signature vanilla milkshake",
                0
        ));
        itemMenus.put(15, new ItemMenu(
                15,
                R.drawable.drink,
                "Chocolate Milkshake",
                2.50,
                "500mL signature chocolate milkshake",
                0
        ));
    }

}