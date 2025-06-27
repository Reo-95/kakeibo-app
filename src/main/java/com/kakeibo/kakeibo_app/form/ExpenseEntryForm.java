package com.kakeibo.kakeibo_app.form;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ExpenseEntryForm {

    @NotNull(message = "{expense.date.required}")
    private String date;

    @NotBlank(message = "{expense.category.required}")
    private String category;

    @NotNull(message = "{expense.amount.required}")
    @Min(value = 1, message = "{expense.amount.min}")
    private Integer amount;

    private String memo;
}
