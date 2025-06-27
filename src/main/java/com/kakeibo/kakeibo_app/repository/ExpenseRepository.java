package com.kakeibo.kakeibo_app.repository;

import com.kakeibo.kakeibo_app.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
