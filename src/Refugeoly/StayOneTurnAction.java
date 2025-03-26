package Refugeoly;

public class StayOneTurnAction extends Action{
    
    @Override
    public void act(Refugee refugee) {
        refugee.stopTurn();
        System.out.println("Ο παίκτης " + refugee.getName() + " δεν παίζει για 1 γύρο");
    }
}
