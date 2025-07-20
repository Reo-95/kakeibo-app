package com.kakeibo.kakeibo_app.repository;

import com.kakeibo.kakeibo_app.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Long> {

    @Query("SELECT i.category, SUM(i.amount) " +
           "FROM Income i " +
           "WHERE FUNCTION('TO_CHAR', i.date, 'YYYY-MM') = :yearMonth " +
           "GROUP BY i.category")
    List<Object[]> findCategoryTotalByMonth(@Param("yearMonth") String yearMonth);
}
