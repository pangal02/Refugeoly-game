package Refugeoly;

import java.util.ArrayList;

public class Squares {
    private int number;
    private String description;
    private String text;
    private Board board;
    private ArrayList<Action> actions = new ArrayList<>();
    
    public Squares(int number, String description, String text, Board board){
        this.number = number;
        this.description = description;
        this.text = text;
        this.board = board;
    }
    
    public void addAction(Action action){
        actions.add(action);
    }
    
    public Action returnAction(int num){
        return actions.get(num);
    }
    
    public int getSquareNumber(){
        return number;
    }
    
    public String getSquareDescription(){
        return description;
    }
    
    public String getSquareText(){
        return text;
    }
}