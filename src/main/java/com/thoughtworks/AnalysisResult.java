package com.thoughtworks;

import com.thoughtworks.Discount.*;

public class AnalysisResult {
    AnalysisOrder analysisOrder ;
    double finalDePrice;
    Promotion finalPlan;

    public AnalysisResult(AnalysisOrder analysisOrder) {
        this.analysisOrder = analysisOrder;
        ChooseWhatPlan chooseWhatPlan = new ChooseWhatPlan(analysisOrder.getTotalPrice(),analysisOrder.getItemMap());
        this.finalPlan = chooseWhatPlan.getFinalPlan();
        this.finalDePrice = finalPlan.makeCheap();
    }

    public Promotion getFinalPlan() {
        return finalPlan;
    }
}
