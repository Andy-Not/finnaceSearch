package com.example.finnacesearch.service;

import com.example.finnacesearch.service.model.StockWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author joandy alejo garcia
 */
@SpringBootTest
class StockServiceTest {
    @Autowired
    private StockService stockService;


    @Test
    void invoke(){
        final StockWrapper stock = stockService.findStock("UU.L");
        System.out.println(stock.getStock());
    }

}