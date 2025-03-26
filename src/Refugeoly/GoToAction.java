package Refugeoly;

public class GoToAction extends Action{
    private final int[][] box = {{4, 0},
                                 {5, 0},
                                 {15, 5},
                                 {18, 22},
                                 {23, 29},
                                 {25, 15},
                                 {29, 31},
                                 {30, 24},
                                 {33, 17},
                                 {35, 25},
                                 {38, 0}};
    
    @Override
    public void act(Refugee refugee) {
        int index = 0;
        Squares curSquare = refugee.getCurrSqr();
        int curNum = curSquare.getSquareNumber();
        boolean flag = false; //Δεν εχει βρεθεί
        
        while(flag == false){
            if(box[index][0] == curNum){
                flag = true; //βρεθηκε το τετραγωνο
            }
            else{
                index++;
            }
        }
        int nextSq = box[index][1];
        Board b1 = refugee.getBoard();
            refugee.moveTo(b1.getSquare(nextSq));
    }    
}
