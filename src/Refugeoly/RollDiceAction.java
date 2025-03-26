package Refugeoly;

public class RollDiceAction extends Action {

    private Zari zari = new Zari();

    @Override
    public void act(Refugee refugee) {
        zari.throwDice();
        int value = zari.getValue();
//        getZari();
        Board b1 = refugee.getBoard();
        Squares sqr = refugee.getCurrSqr();
        System.out.println("Ζάρι: " + value);
        if ((refugee.getCurrSqr().getSquareNumber() + value) > 39) {
            int k = ((refugee.getCurrSqr().getSquareNumber() + value) - 39);
            sqr = b1.getSquare(39 - k);   
            refugee.moveTo(sqr);
        }

        else if (refugee.getCurrSqr().getSquareNumber() <= 39) {
            refugee.moveTo(b1.getSquare(sqr.getSquareNumber() + value));
        }
    }

    public int getZari() {
        return zari.getValue();
    }
}