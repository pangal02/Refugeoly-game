package Refugeoly;

public class ReceiverEntity implements MoneyReceiver{
    private String name;
    private double money;
    
    public ReceiverEntity(String name, double money){
        this.name = name;
        this.money = money;
    }
    
    public String getName(){
        return name;
    }
    
    
    public double getMoney(){
        return money;
    }
    
    public void setMoney(double money){
        this.money = money;
    }
    @Override
    public void receiveMoney(double value){
        money += value;
    }
    
}
