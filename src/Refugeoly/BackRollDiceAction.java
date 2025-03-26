package Refugeoly;

public class BackRollDiceAction extends Action{
    private Zari zari = new Zari();

    @Override
    public void act(Refugee refugee){
        zari.throwDice();
        int value = zari.getValue();
        getZari();
            Board b1 = refugee.getBoard();
            Squares sqr = refugee.getCurrSqr();
            try{
                int k =sqr.getSquareNumber()-value;
                refugee.moveTo(b1.getSquare(k));
            }catch(ArrayIndexOutOfBoundsException e){}
    }
    public int getZari(){
        return zari.getValue();
    }
}