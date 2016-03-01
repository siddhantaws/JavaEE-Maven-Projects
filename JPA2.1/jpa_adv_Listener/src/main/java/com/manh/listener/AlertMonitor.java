package com.manh.listener;


import javax.persistence.PrePersist;

import com.manh.entitie.Employee;

public class AlertMonitor {

    @PrePersist
    public void validateCreate(Employee e) {
        System.out.println("----> AlertMonitor: validateCreate() gets called"+e);
    }
}
