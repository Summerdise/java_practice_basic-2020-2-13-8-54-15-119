package com.thoughtworks.Discount;

import com.thoughtworks.*;

import java.util.*;

public class ChooseWhatPlan {
    GetDeSixDiscount deSixDiscount;
    GetHalfDiscount halfDiscount;
    GetNoneDiscount noneDiscount;
    Promotion finalPlan;

    public GetDeSixDiscount getDeSixDiscount() {
        return deSixDiscount;
    }

    public GetHalfDiscount getHalfDiscount() {
        return halfDiscount;
    }

    public GetNoneDiscount getNoneDiscount() {
        return noneDiscount;
    }

    public Promotion getFinalPlan() {
        return finalPlan;
    }

    public ChooseWhatPlan(double totalPrice, Map<Dish, Integer> itemMap) {
        this.deSixDiscount = new GetDeSixDiscount(totalPrice);
        this.halfDiscount = new GetHalfDiscount(itemMap);
        this.noneDiscount = new GetNoneDiscount();
        this.finalPlan = chooseProcess();
    }

    public Promotion chooseProcess() {
        double deSix = deSixDiscount.cheaperPrice;
        double deHalf = halfDiscount.cheaperPrice;
        if (deHalf == 0 && deSix == 0) {
            return this.noneDiscount;
        } else if (deHalf >= deSix) {
            return this.halfDiscount;
        } else {
            return this.deSixDiscount;
        }
    }
}
