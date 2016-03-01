package com.manh.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class MyStartupBean {

    @PostConstruct
    private void startup() {
        System.out.println("----startup() method of MyStartupBean is called");
    }

    @PreDestroy
    private void shutdown() {
        System.out.println("----shutdown() method of MyStartupBean is called");
    }
}
