package com.example.finnacesearch.service;
import com.example.finnacesearch.service.model.StockWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yahoofinance.YahooFinance;

import javax.imageio.IIOException;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * This service will be responsible for gathering data from the api
 *
 * @author joandy alejo garcia
 */

@AllArgsConstructor
@Service
public class StockService {
    public StockWrapper findStock(final String ticker){
        try {
            return new StockWrapper(YahooFinance.get(ticker));
        }catch (IOException x){
            System.out.println("error found!");
        }
        return null;
    }
    public BigDecimal findPrice(final StockWrapper stock) throws IOException {
        return stock.getStock().getQuote(true).getPrice();
    }
}
