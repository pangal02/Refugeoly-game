package Refugeoly;

import java.util.Scanner;

public class OptionsAction extends Action {
    private ReceiverEntity receiver;
    
    @Override
    public void act(Refugee refugee) {
        System.out.println("Διάλεξε:" + "\n" + "Επιλογή 1: πλήρωσε 1500 στην MafiaBank και ρίξε το ζάρι");
        System.out.println("Επιλογη 2: μην πληρώσεις και χάσε την σειρά σου για 2 γύρους");
        System.out.println("Για επιλογή 1 γράψε 1 και για επιλογή 2 γράψε 2");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        switch(num){
            case 1:
                new PayMoneyAction(1500,receiver);
                new RollDiceAction();
                break;
            case 2:
                //new StayOneTurnAction();
                System.out.println("Ο παίκτης " + refugee.getName() + " χάνει έναν γύρο! (ΜΗ ΥΛΟΠΟΙΗΣΙΜΟ)");
                break;
        }
    }
}
