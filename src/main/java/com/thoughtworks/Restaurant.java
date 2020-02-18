package com.thoughtworks;

public class Restaurant {

    public String bestCharge(String selectedItems) {
        Rendering rendering = new Rendering(selectedItems);
        return rendering.getPrintContent();
    }
}
