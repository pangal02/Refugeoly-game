package Refugeoly;

public class WinAction extends Action{
    @Override
    public void act(Refugee refugee){
        Squares sqr = refugee.getCurrSqr();
        if( sqr.getSquareNumber() == 39  || sqr.getSquareNumber() == 36 ){
            refugee.win();
            System.out.println("\nΟ παίκτης " + refugee.getName() + " είναι ο νικητής!");
        }
    }
}
