package com.thoughtworks.Discount;

public class GetNoneDiscount implements Promotion {
    double cheaperPrice;

    public GetNoneDiscount() {
        this.cheaperPrice = 0.0d;
    }

    @Override
    public double makeCheap() {
        return 0.0d;
    }
}
