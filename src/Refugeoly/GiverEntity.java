package Refugeoly;

public class GiverEntity implements MoneyGiver{
    private final String name;
    private double money;
    
    public GiverEntity(String name, double money){
        this.name = name;
        this.money = money;
    }
    
    public String getName(){
        return name;
    }
    
    public double getMoney(){
        return money;
    }
    
    
    @Override
    public void giveMoney(double value)throws NoMoneyException{
         if(money < value){
            System.out.println("Μη επαρκες υπολοιπο!");
            throw new NoMoneyException();
         }
         else{
             money -= value;
             System.out.println("Η συναλαγή ολοκληρώθηκε!");
         }
    }

}
