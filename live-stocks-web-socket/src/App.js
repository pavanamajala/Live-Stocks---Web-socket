import React, { useState } from 'react';
import RandomStocks from './RandomStocks';
import './App.css';

function App() {

  const [typeOfStocks, setTypeOfStocks] = useState();

  const renderPaticularStocks = () => {
    if (typeOfStocks === "Random Stocks") return <RandomStocks/>;
  }

  return (
    <div className="App">
      <header className="App-header">
        <button onClick={() => setTypeOfStocks("Random Stocks")}>Random Stocks</button>
        <button onClick={() => setTypeOfStocks("Live Stocks")}>Live Stocks</button>
        {renderPaticularStocks()}
      </header>
    </div>
  );
}

export default App;
