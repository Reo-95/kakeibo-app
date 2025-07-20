package com.kakeibo.kakeibo_app.repository;

import com.kakeibo.kakeibo_app.entity.Expense;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("SELECT e.category, SUM(e.amount) " +
           "FROM Expense e " +
           "WHERE FUNCTION('TO_CHAR', e.date, 'YYYY-MM') = :yearMonth " +
           "GROUP BY e.category")
    List<Object[]> findCategoryTotalByMonth(@Param("yearMonth") String yearMonth);
}
