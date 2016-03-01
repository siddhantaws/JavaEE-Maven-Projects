

package com.manh.jsf;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.manh.ejb.CounterBean;


/**
 *
 * @author ian
 */
@ManagedBean
@RequestScoped
public class Count {
    @EJB
    private CounterBean counterBean;
    private int hitCount;

    public Count() {
        this.hitCount = 0;
    }

    public int getHitCount() {
        hitCount = counterBean.getHits();

        return hitCount;
    }

    public void setHitCount(int newHits) {
        this.hitCount = newHits;
    }
}
