package Refugeoly;

import java.util.Random;

public class Zari {
    private final int MAX_VALUE = 6;
    private int value;
    private Random rnd = new Random();
    
    public Zari(){
        
    }
    
    public int getValue()
    {
        return value;
    }
    
    public void throwDice()
    {
        value = rnd.nextInt(MAX_VALUE) + 1;
    }
               
}
