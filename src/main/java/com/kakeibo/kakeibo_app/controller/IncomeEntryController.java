package com.kakeibo.kakeibo_app.controller;

import com.kakeibo.kakeibo_app.form.IncomeEntryForm;
import com.kakeibo.kakeibo_app.service.IncomeEntryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class IncomeEntryController {

    private final IncomeEntryService incomeEntryService;

    @GetMapping("/income/add")
    public String showIncomeForm(Model model) {
        model.addAttribute("incomeEntryForm", new IncomeEntryForm());

        // カテゴリの仮データ（本来はDBから取得）
        List<String> categories = Arrays.asList("給与", "ボーナス", "副業", "その他");
        model.addAttribute("categories", categories);

        return "income-entry";
    }

    @PostMapping("/income/add")
    public String submitIncomeForm(@Valid @ModelAttribute IncomeEntryForm form,
                                    BindingResult bindingResult,
                                    Model model) {
        if (bindingResult.hasErrors()) {
            // カテゴリ再セット（エラー時も必要）
            List<String> categories = Arrays.asList("給与", "ボーナス", "副業", "その他");
            model.addAttribute("categories", categories);

            return "income-entry";
        }

        // 後でサービス経由でDB保存予定
        incomeEntryService.register(form);// ★サービスを呼び出す

        return "redirect:/";
    }
}
