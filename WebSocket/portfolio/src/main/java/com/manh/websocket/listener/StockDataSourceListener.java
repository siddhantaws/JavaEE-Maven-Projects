package com.manh.websocket.listener;

import com.manh.websocket.data.PortfolioUpdate;

public interface StockDataSourceListener {
    
    public void handleNewStockData(PortfolioUpdate pu);
    
}
