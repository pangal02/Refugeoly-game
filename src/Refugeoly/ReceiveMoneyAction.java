
package Refugeoly;

public class ReceiveMoneyAction extends Action {

    private double money;
    private GiverEntity giver;
    
    public ReceiveMoneyAction(double money, GiverEntity giver){
        this.money = money;
        this.giver = giver;
        
    }
    
    @Override
    public void act(Refugee refugee) {
        try{
        giver.giveMoney(money);
        refugee.receiveMoney(money);
        }
        catch(NoMoneyException ex) {
            System.out.println(ex + "Μη επαρκες υπολοιπο!(ReceiveMoneyAction)");
        }
    }
}
