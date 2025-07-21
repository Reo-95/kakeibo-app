package com.kakeibo.kakeibo_app.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {

    @NotBlank(message = "{login.email.required}")
    @Email(message = "{login.email.invalid}")
    private String email;

    @NotBlank(message = "{login.password.required}")
    private String password;
}
