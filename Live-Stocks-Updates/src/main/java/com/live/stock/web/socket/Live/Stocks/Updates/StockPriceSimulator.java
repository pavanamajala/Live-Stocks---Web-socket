package com.live.stock.web.socket.Live.Stocks.Updates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class StockPriceSimulator {
    private static final Logger logger = LoggerFactory.getLogger(StockPriceSimulator.class);

    @Autowired
    private StockPriceHandler stockPriceHandler;

    private final Random random = new Random();

    @Scheduled(fixedRate = 5000)
    public void simulatePriceUpdates() throws Exception {
        logger.info("Simulating price update...");
        String stockSymbol = "AAPL";
        String price = String.format("%.2f", 100 + random.nextDouble() * 50);
        stockPriceHandler.broadcastPriceUpdate(stockSymbol, price);
    }
}
