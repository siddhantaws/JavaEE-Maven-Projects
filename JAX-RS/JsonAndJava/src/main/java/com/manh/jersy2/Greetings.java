/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manh.jersy2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Suryasnata
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Greetings 
{
    private String first;
    private String last;
    public  Greetings (String first,String last)
    {
        this.first=first;
        this.last=last;
    }
}
