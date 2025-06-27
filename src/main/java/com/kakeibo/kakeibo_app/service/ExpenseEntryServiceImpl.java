package com.kakeibo.kakeibo_app.service;

import com.kakeibo.kakeibo_app.form.ExpenseEntryForm;
import com.kakeibo.kakeibo_app.entity.Expense;
import com.kakeibo.kakeibo_app.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseEntryServiceImpl implements ExpenseEntryService {

    private final ExpenseRepository expenseRepository;

    @Override
    public void register(ExpenseEntryForm form) {
        Expense expense = new Expense();
        expense.setDate(LocalDate.parse(form.getDate()));
        expense.setCategory(form.getCategory());
        expense.setAmount(form.getAmount());
        expense.setMemo(form.getMemo());

        expenseRepository.save(expense);
    }
}
