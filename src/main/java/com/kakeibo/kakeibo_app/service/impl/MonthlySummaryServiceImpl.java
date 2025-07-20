package com.kakeibo.kakeibo_app.service.impl;

import com.kakeibo.kakeibo_app.dto.MonthlyCategorySummaryDto;
import com.kakeibo.kakeibo_app.repository.ExpenseRepository;
import com.kakeibo.kakeibo_app.repository.IncomeRepository;
import com.kakeibo.kakeibo_app.service.MonthlySummaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class MonthlySummaryServiceImpl implements MonthlySummaryService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private IncomeRepository incomeRepository;

    @Override
    public List<MonthlyCategorySummaryDto> getMonthlySummary(String yearMonth) {

        // 支出カテゴリ集計
        List<Object[]> expenseResults = expenseRepository.findCategoryTotalByMonth(yearMonth);
        Map<String, Integer> expenseMap = new HashMap<>();
        int totalExpense = 0;

        for (Object[] row : expenseResults) {
            String category = (String) row[0];
            int amount = ((Number) row[1]).intValue();
            expenseMap.put(category, amount);
            totalExpense += amount;
        }

        // 収入カテゴリ集計
        List<Object[]> incomeResults = incomeRepository.findCategoryTotalByMonth(yearMonth);
        Map<String, Integer> incomeMap = new HashMap<>();
        int totalIncome = 0;

        for (Object[] row : incomeResults) {
            String category = (String) row[0];
            int amount = ((Number) row[1]).intValue();
            incomeMap.put(category, amount);
            totalIncome += amount;
        }

        // 全カテゴリ一覧
        Set<String> allCategories = new HashSet<>();
        allCategories.addAll(expenseMap.keySet());
        allCategories.addAll(incomeMap.keySet());

        List<MonthlyCategorySummaryDto> summaries = new ArrayList<>();
        for (String category : allCategories) {
            int expense = expenseMap.getOrDefault(category, 0);
            int income = incomeMap.getOrDefault(category, 0);

            double expenseRatioValue = (totalExpense > 0) ? (expense * 100.0 / totalExpense) : 0.0;
            double incomeRatioValue = (totalIncome > 0) ? (income * 100.0 / totalIncome) : 0.0;

            String expenseRatio = String.format("%.1f%%", expenseRatioValue);
            String incomeRatio = String.format("%.1f%%", incomeRatioValue);

            summaries.add(new MonthlyCategorySummaryDto(category, expense, income, expenseRatio, incomeRatio));
        }

        return summaries;
    }
}
