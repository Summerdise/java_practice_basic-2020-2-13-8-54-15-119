package com.thoughtworks;

import com.thoughtworks.Discount.*;

import java.util.*;

public class Rendering {
    String selectedItems;
    String printContent;
    AnalysisOrder analysisOrder;
    AnalysisResult analysisResult;

    public Rendering(String selectedItems) {
        this.selectedItems = selectedItems;
        this.analysisOrder = new AnalysisOrder(selectedItems);
        this.analysisResult = new AnalysisResult(analysisOrder);
        this.printContent = printMessage();
    }

    public String getPrintContent() {
        return printContent;
    }

    public String printMessage() {
        Map<Dish, Integer> itemMap = analysisOrder.getItemMap();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("============= 订餐明细 =============\n");
        for (Dish nowDish : itemMap.keySet()) {
            String itemName = nowDish.getName();
            double itemPrice = nowDish.getPrice();
            int itemNum = itemMap.get(nowDish);
            int oneItemTotalPrice = new Double(itemNum * itemPrice).intValue();
            stringBuilder.append(String.format("%s x %d = %d元\n", itemName, itemNum, oneItemTotalPrice));
        }
        stringBuilder.append("-----------------------------------\n");
        Promotion finalPlan = analysisResult.getFinalPlan();
        if (!(finalPlan instanceof GetNoneDiscount)) {
            stringBuilder.append("使用优惠:\n");
            if (finalPlan instanceof GetHalfDiscount) {
                int dePrice = (int) ((GetHalfDiscount) finalPlan).getCheaperPrice();
                stringBuilder.append("指定菜品半价(黄焖鸡，凉皮)，省" + dePrice + "元\n");
            } else {
                stringBuilder.append("满30减6元，省6元\n");
            }
            stringBuilder.append("-----------------------------------\n");
        }
        double finalPrice = analysisOrder.getTotalPrice() - finalPlan.makeCheap();
        stringBuilder.append(String.format("总计：%d元\n", new Double(finalPrice).intValue()));
        stringBuilder.append("===================================");
        return stringBuilder.toString();
    }
}
