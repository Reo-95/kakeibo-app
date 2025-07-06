package com.kakeibo.kakeibo_app.repository;

import com.kakeibo.kakeibo_app.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
