package com.live.stock.web.socket.Live.Stocks.Updates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
public class StockPriceHandler extends TextWebSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(StockPriceHandler.class);
    private final List<WebSocketSession> sessions = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("Connection established with session: " + session.getId());
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("Connection closed with session: " + session.getId() + " due to " + status.getReason());
        sessions.remove(session);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        logger.error("Transport error with session: " + session.getId(), exception);
        session.close(CloseStatus.SERVER_ERROR);
    }

    public void broadcastPriceUpdate(String stockSymbol, String price) throws Exception {
        TextMessage message = new TextMessage(stockSymbol + ": " + price);
        for (WebSocketSession session : sessions) {
            logger.info("Sending message to session: " + session.getId());
            session.sendMessage(message);
        }
    }
}
