package com.kakeibo.kakeibo_app.controller;

import com.kakeibo.kakeibo_app.form.RegisterForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    /** 新規登録画面の表示 */
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register"; // register.html を表示
    }

    /** 新規登録処理（バリデーションのみ、認証処理は未実装） */
    @PostMapping("/register")
    public String doRegister(@Valid RegisterForm registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register"; // 入力エラーがあれば再表示
        }

        // 👇 ここに後でCognito連携の登録処理を実装予定

        return "redirect:/register/complete"; // 完了画面へリダイレクト
    }
    
    @GetMapping("/register/complete")
    public String showCompletePage() {
        return "registerComplete";
    }
}
