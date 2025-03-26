package Refugeoly;

public class PayMoneyAction extends Action {

    private double money;
    private ReceiverEntity receiver;
    
    public PayMoneyAction(double money, ReceiverEntity receiver){
        this.money = money;
        this.receiver = receiver;
    }
    
    @Override
    public void act(Refugee refugee) {
        try {
            refugee.giveMoney(money);
            receiver.receiveMoney(money);
            refugee.setExpenses(money);
        } 
        catch (NoMoneyException ex) {
            System.out.println(ex + "Μη επαρκες υπολοιπο!(PayMoneyAction)");
        }        
    }   
}
