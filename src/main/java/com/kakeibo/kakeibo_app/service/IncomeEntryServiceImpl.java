package com.kakeibo.kakeibo_app.service;

import com.kakeibo.kakeibo_app.entity.Income;
import com.kakeibo.kakeibo_app.form.IncomeEntryForm;
import com.kakeibo.kakeibo_app.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class IncomeEntryServiceImpl implements IncomeEntryService {

    private final IncomeRepository incomeRepository;

    @Override
    public void register(IncomeEntryForm form) {
        Income income = new Income();
        income.setDate(form.getDate());
        income.setAmount(form.getAmount());
        income.setCategory(form.getCategory());
        income.setMemo(form.getMemo());
        income.setCreatedAt(LocalDate.now());

        incomeRepository.save(income);
    }
}
