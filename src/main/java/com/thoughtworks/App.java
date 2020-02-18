package com.thoughtworks;

import java.util.*;

public class App {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("请点餐（菜品Id x 数量，用逗号隔开）：");
    String selectedItems = scan.nextLine();
    Restaurant restaurant = new Restaurant();
    String summary = restaurant.bestCharge(selectedItems);
    System.out.println(summary);
  }
}
