package com.manh.ejb.stateless;

import java.util.Random;
import javax.ejb.Stateless;
@Stateless
public class DiceBean implements Dice 
{

    public int play()
    {
    	Random random = new Random();
    	return random.nextInt(10);
    }

}
