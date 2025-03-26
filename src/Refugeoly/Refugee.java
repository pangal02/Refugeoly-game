package Refugeoly;

public class Refugee implements MoneyGiver, MoneyReceiver{
    private final String name;
    private double money;
    private Board board;
    private Squares currSqr;
    private ReceiverEntity expenses;
    private int life;
    private boolean stayOneTurn;
    private boolean winner = false;
    
    public Refugee(String name, Board board){
        this.name = name;
        money = 10000;
        this.board = board;
        life = 1;
        stayOneTurn = false;
        this.currSqr = board.getSquare(0);
        expenses = new ReceiverEntity(name, 0);
    }
    
    
    public String getName(){
        return name;
    }
    
    public double getMoney(){
        return money;
    }
    
    public Board getBoard(){
        return board;
    }
   
    public void win(){
        this.winner = true;
    }
    
    public boolean getWinner(){
        return winner;
    }
    
    public Squares getCurrSqr(){
        return currSqr;
    }
    
    public void addLife(){
        life++;
    }
    
    public void reduceLife(){
        life--;
    }
    
    public int getLife(){
        return life;
    }
    
    public void setExpenses(double money){
        expenses.setMoney(money);
    }
    
    public ReceiverEntity getExpences(){
        return expenses;
    }
    
    public double getMoneyExpenses(){
        return expenses.getMoney();
    }
    
    public boolean getTurn(){
        return stayOneTurn;
    }
    
    public void stopTurn(){
        stayOneTurn = true;
    }
    
    public void StartTurn(){
        stayOneTurn = false;
    }

    public void moveTo(Squares sqr){
        this.currSqr = sqr;
    }
    
    @Override
    public void giveMoney(double value) throws NoMoneyException{
        if(value <= money){
            money -= value;
            System.out.println("Τα χρήματα αφαιρέθηκαν από τον παίκτη " + getName());
        }
        else{
            System.out.println("Μη επαρκες υπολοιπο!");           
            throw new NoMoneyException();
        }
        
    }    
    
    @Override
    public void receiveMoney(double value){
        money += value;
        System.out.println("Τα χρήματα προσθέθηκαν στον παίκτη " + getName());
    }
}
