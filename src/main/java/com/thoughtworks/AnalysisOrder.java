package com.thoughtworks;

import java.util.*;

public class AnalysisOrder {

    String selectedItems;
    Map<Dish, Integer> itemMap;
    double totalPrice;

    public AnalysisOrder(String selectedItems) {
        this.selectedItems = selectedItems;
        this.itemMap = preTreat(selectedItems);
        this.totalPrice = calculateTotalPrice();
    }

    public Map<Dish, Integer> getItemMap() {
        return itemMap;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Map<Dish, Integer> preTreat(String selectedItems) {
        List<Dish> allDishes = new DataProvider().getDishes();
        Map<Dish, Integer> itemMap = new LinkedHashMap<>();
        String[] totalItemString = selectedItems.split(",");
        for (int i = 0; i < totalItemString.length; i++) {
            String[] everyItemString = totalItemString[i].split(" x ");
            String itemName = everyItemString[0];
            int itemNum = Integer.valueOf(everyItemString[1]);
            for (int j = 0; j < allDishes.size(); j++) {
                Dish nowDish = allDishes.get(j);
                if (nowDish.getId().equals(itemName)) {
                    itemMap.put(nowDish, itemNum);
                }
            }
        }
        return itemMap;
    }

    public double calculateTotalPrice() {
        int totalPrice = 0;
        for (Dish nowDish : itemMap.keySet()) {
            totalPrice += nowDish.getPrice() * itemMap.get(nowDish);
        }
        return totalPrice;
    }

}
