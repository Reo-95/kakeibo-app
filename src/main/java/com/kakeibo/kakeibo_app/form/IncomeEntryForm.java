package com.kakeibo.kakeibo_app.form;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class IncomeEntryForm {

    @NotNull(message = "{date.required}")
    @PastOrPresent(message = "{date.pastOrPresent}")  // 過去 or 今日までOK
    private LocalDate date;

    @NotNull(message = "{amount.required}")
    @Min(value = 0, message = "{amount.min}")  // 0円以上（0OKにした場合）
    private Integer amount;

    @NotBlank(message = "{category.required}")
    private String category;

    @Size(max = 100, message = "{memo.max}")
    private String memo;
}