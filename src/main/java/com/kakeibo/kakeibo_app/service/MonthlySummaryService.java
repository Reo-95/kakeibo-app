package com.kakeibo.kakeibo_app.service;

import com.kakeibo.kakeibo_app.dto.MonthlyCategorySummaryDto;
import java.util.List;

public interface MonthlySummaryService {
    List<MonthlyCategorySummaryDto> getMonthlySummary(String yearMonth);
}
