package Refugeoly;

import java.util.ArrayList;

public class Board {

    private ArrayList<Squares> Board = new ArrayList<>();
    
    public void addSquare(Squares sqr) {
        Board.add(sqr);
    }
    
    public Squares getSquare(int number) {
        return Board.get(number);
    }

    public void printBoard() {
        for (Squares sq : Board) {
            System.out.println(sq.getSquareNumber());
            System.out.println(sq.getSquareDescription());
            System.out.println(sq.getSquareText());
        }
    }
    
    
}