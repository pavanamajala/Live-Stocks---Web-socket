import React, { useEffect, useState } from 'react';

const RandomStocks = () => {
    const [prices, setPrices] = useState([]);

    useEffect(() => {
        const socket = new WebSocket('ws://localhost:8080/stock-price');

        socket.onopen = () => {
            console.log('WebSocket connection established');
        };

        socket.onmessage = (event) => {
            setPrices((prevPrices) => [...prevPrices, event.data]);
        };

        socket.onerror = (error) => {
            console.error('WebSocket error:', error);
        };

        socket.onclose = (event) => {
            console.log('WebSocket connection closed:', event);
        };

        return () => {
            socket.close();
        };
    }, []);

    return (
        <div>
            <h1>Live Stock Prices</h1>
            <div id="stockPrices">
                {prices.map((price, index) => (
                    <div key={index}>{price}</div>
                ))}
            </div>
        </div>
    );
};

export default RandomStocks;
