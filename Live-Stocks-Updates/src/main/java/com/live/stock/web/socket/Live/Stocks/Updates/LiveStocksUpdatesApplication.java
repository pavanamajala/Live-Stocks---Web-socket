package com.live.stock.web.socket.Live.Stocks.Updates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LiveStocksUpdatesApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiveStocksUpdatesApplication.class, args);
    }
}
