package com.kakeibo.kakeibo_app.controller;

import com.kakeibo.kakeibo_app.form.ExpenseEntryForm;
import com.kakeibo.kakeibo_app.service.ExpenseEntryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ExpenseEntryController {

    private final ExpenseEntryService expenseEntryService;

    // GET: 支出登録画面の表示
    @GetMapping("/expense/entry")
    public String showEntryForm(Model model) {
        model.addAttribute("expenseEntryForm", new ExpenseEntryForm());
        return "expense-entry";
    }

    // POST: 支出データの登録処理（バリデーション含む）
    @PostMapping("/expense/entry")
    public String submitEntryForm(
            @ModelAttribute("expenseEntryForm") @Valid ExpenseEntryForm form,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "expense-entry"; // 入力ミスがあれば再表示
        }

        expenseEntryService.register(form); // ★サービスを呼び出す

        // 完了画面または再表示（仮で再表示）
        model.addAttribute("successMessage", "登録が完了しました！");
        model.addAttribute("expenseEntryForm", new ExpenseEntryForm()); // 空フォームでリセット

        return "expense-entry";
    }
}
