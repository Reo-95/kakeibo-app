package com.kakeibo.kakeibo_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlyCategorySummaryDto {
    private String category;
    private int totalExpense;
    private int totalIncome;
    private String expenseRatio; // 支出割合
    private String incomeRatio;  // 収入割合
}
