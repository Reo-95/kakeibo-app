package com.kakeibo.kakeibo_app.controller;

import com.kakeibo.kakeibo_app.form.LoginForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    /** ログイン画面の表示 */
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";  // login.html を表示
    }

    /** ログイン処理（今は認証なしで仮遷移） */
    @PostMapping("/login")
    public String doLogin(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";  // バリデーションエラーがあればログイン画面に戻る
        }

        // --- 認証処理はまだ未実装（後でCognitoなどを追加） ---

        return "redirect:/";  // 仮にログイン成功とみなしてホーム画面へ
    }
}
