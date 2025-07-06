package com.kakeibo.kakeibo_app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String showHome(Model model) {
        // 仮データ（後でDBから取得）
        int totalIncome = 150000;
        int totalExpense = 60000;
        int balance = totalIncome - totalExpense;

        model.addAttribute("income", totalIncome);
        model.addAttribute("expense", totalExpense);
        model.addAttribute("balance", balance);

        return "home";
    }
}
