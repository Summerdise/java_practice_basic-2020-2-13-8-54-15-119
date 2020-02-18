package com.thoughtworks.Discount;

import com.thoughtworks.*;

import java.util.*;

public class GetHalfDiscount implements Promotion {
    double cheaperPrice;
    Map<Dish, Integer> itemMap;
    List<String> halfDishList;

    public GetHalfDiscount(Map<Dish, Integer> itemMap) {
        this.itemMap = itemMap;
        this.halfDishList = DataProvider.getHalfDishIds();
        this.cheaperPrice = makeCheap();
    }

    public double getCheaperPrice() {
        return cheaperPrice;
    }

    public Map<Dish, Integer> getItemMap() {
        return itemMap;
    }

    public List<String> getHalfDishList() {
        return halfDishList;
    }

    @Override
    public double makeCheap() {
        Map<Dish, Integer> halfDishMap = getHalfDishMap();
        int cheaperPrice = 0;
        for (Dish nowDish : halfDishMap.keySet()) {
            cheaperPrice += nowDish.getPrice() * halfDishMap.get(nowDish)/2;
        }
        return cheaperPrice;
    }

    public Map<Dish, Integer> getHalfDishMap() {
        Map<Dish, Integer> halfDishMap = new LinkedHashMap<>();
        for (int i = 0; i < halfDishList.size(); i++) {
            String str = halfDishList.get(i);
            for (Dish key : itemMap.keySet()) {
                if (key.getId().equals(str)) {
                    halfDishMap.put(key, itemMap.get(key));
                }
            }
        }
        return halfDishMap;
    }
}
