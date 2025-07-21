package com.kakeibo.kakeibo_app.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm {

    @NotBlank(message = "{register.email.required}")
    @Email(message = "{register.email.invalid}")
    private String email;

    @NotBlank(message = "{register.password.required}")
    private String password;

    @NotBlank(message = "{register.confirmPassword.required}")
    private String confirmPassword;
}
