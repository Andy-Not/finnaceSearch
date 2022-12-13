package com.example.finnacesearch.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import yahoofinance.Stock;

import javax.imageio.IIOException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Responsible for saving data about a given stock
 *
 * @author joandy alejo garcia
 */
@Getter
@With
@AllArgsConstructor
public class StockWrapper {
    final Stock stock;
    final LocalDateTime lastAccessed;
    public StockWrapper(final Stock stock){
        this.stock = stock;
        //could have added a clock here
        lastAccessed = LocalDateTime.now();
    }


}
