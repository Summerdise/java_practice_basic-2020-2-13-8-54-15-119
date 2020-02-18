package com.thoughtworks.Discount;

import com.thoughtworks.*;

import java.util.*;

public class GetDeSixDiscount implements Promotion{
    double cheaperPrice;
    double totalPrice;

    public GetDeSixDiscount(double totalPrice) {
        this.totalPrice = totalPrice;
        this.cheaperPrice = makeCheap();
    }

    public double getCheaperPrice() {
        return cheaperPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public double makeCheap() {
        if(this.totalPrice<30){
            return 0.0d;
        }else{
            return 6.0d;
        }
    }
}
