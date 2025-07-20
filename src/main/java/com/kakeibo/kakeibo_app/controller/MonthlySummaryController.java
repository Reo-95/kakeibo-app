package com.kakeibo.kakeibo_app.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kakeibo.kakeibo_app.dto.MonthlyCategorySummaryDto;
import com.kakeibo.kakeibo_app.service.MonthlySummaryService;

@Controller
public class MonthlySummaryController {
    
    @Autowired
    private MonthlySummaryService summaryService;
    
    @GetMapping("/summary/monthly")
    public String showMonthlySummary(
            @RequestParam(name = "yearMonth", required = false) String yearMonth,
            Model model) {

        // 初期表示：当月（例：2025-07）
        if (yearMonth == null || yearMonth.isEmpty()) {
            yearMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
        }

        // View側に渡す（今は仮データのみ）
        model.addAttribute("selectedMonth", yearMonth);

        // Serviceからカテゴリ別集計リストを取得
        List<MonthlyCategorySummaryDto> summaries = summaryService.getMonthlySummary(yearMonth);
        model.addAttribute("summaries", summaries);

        // 💡合計支出・収入を算出して画面に渡す
        int totalExpense = summaries.stream().mapToInt(MonthlyCategorySummaryDto::getTotalExpense).sum();
        int totalIncome  = summaries.stream().mapToInt(MonthlyCategorySummaryDto::getTotalIncome).sum();

        model.addAttribute("totalExpense", totalExpense);
        model.addAttribute("totalIncome", totalIncome);

        return "summary-monthly";
    }
    
    
}
