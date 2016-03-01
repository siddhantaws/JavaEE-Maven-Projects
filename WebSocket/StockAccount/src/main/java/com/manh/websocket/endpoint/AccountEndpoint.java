package com.manh.websocket.endpoint;


import javax.websocket.*;
import javax.websocket.server.*;

import com.manh.websocket.config.MemberLevelConfigurator;
import com.manh.websocket.data.Account;
import com.manh.websocket.data.AccountUpdate;
import com.manh.websocket.data.DataOptions;
import com.manh.websocket.data.MemberLevel;
import com.manh.websocket.data.PortfolioUpdate;
import com.manh.websocket.data.StockDataSource;
import com.manh.websocket.encoder.AccountUpdateEncoder;
import com.manh.websocket.listener.StockDataSourceListener;

    @ServerEndpoint(
            value="/account/info",
            encoders={AccountUpdateEncoder.class},
            configurator=MemberLevelConfigurator.class
            )

public class AccountEndpoint implements StockDataSourceListener {
    private Account account;
    private StockDataSource dataSource;
    private Session session;
       
    @OnOpen
    public void startAccess(Session session, EndpointConfig ec) {
        this.session = session;
        MemberLevel memberLevel = (MemberLevel) ec.getUserProperties().get(MemberLevelConfigurator.MEMBER_LEVEL);
        DataOptions options = (new DataOptions()).currentPrice(true).percentChange(true);
        this.account = new Account(session.getUserPrincipal(), memberLevel);
        this.dataSource = new StockDataSource(options, memberLevel);
        this.dataSource.addStockDataSourceListener(this);
        this.dataSource.start();
    } 
    
    @OnError
    public void error(Throwable t) {
        System.out.println("error " + t.getMessage());
    }
    
    
    
    public void handleNewStockData(PortfolioUpdate pu) {
        AccountUpdate au = new AccountUpdate(pu.getStocks(), account);
        try {
            this.session.getBasicRemote().sendObject(au);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    
  
         
    
    @OnClose
    public void stop(Session s) {
        this.dataSource.stop();
    }
}
