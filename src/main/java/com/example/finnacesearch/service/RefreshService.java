package com.example.finnacesearch.service;

import com.example.finnacesearch.service.model.StockWrapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author joandy alejo garcia
 */
@Service
public class RefreshService {
    private final Map<StockWrapper, Boolean> stockToRefresh;

    private static final ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);

    private static final Duration refreshPeriod = Duration.ofSeconds(15);

    public RefreshService(){
        stockToRefresh = new HashMap<>();
        setRefreshEvery15minutes();
    }

    private void setRefreshEvery15minutes(){
        schedule.scheduleAtFixedRate(() ->
            stockToRefresh.forEach((stock, value) -> {
                if (stock.getLastAccessed().isBefore(LocalDateTime.now().minus(refreshPeriod))){
                    System.out.println("Setting should refresh: " + stock.getStock().getSymbol());
                    stockToRefresh.remove(stock);
                    stockToRefresh.put(stock.withLastAccessed(LocalDateTime.now()), true);
                }
            }), 0, 15, SECONDS);
    }
}
