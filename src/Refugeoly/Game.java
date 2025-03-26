package Refugeoly;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Board b1 = new Board();
    ArrayList<Refugee> refugees = new ArrayList<>();
    ReceiverEntity MafiaBank, trash;
    GiverEntity NGObank;
    Refugee currPlayer;
    Zari zari;

    public Game() {
        NGObank = new GiverEntity("NGO", 10000);
        MafiaBank = new ReceiverEntity("Mafia", 0);
        zari = new Zari();
        trash = new ReceiverEntity("trash", 0);
    }

    public void newGame() {
        int players = -1;
        fillBoard();
        System.out.println("Πόσοι παίκτες θα παίξουν (1-4);");
        Scanner scanner = new Scanner(System.in);
        do {//ελεγχος παικτων
            try {
                players = Integer.parseInt(scanner.nextLine());
                if (players < 1 || players > 4) {
                    System.out.println("Λάθος Είσοδος! Επιλέξτε από(1-4)");
                }
            } catch (NumberFormatException e) {
                System.out.println("Λάθος Είσοδος! Επιλέξτε από(1-4)");
            }
        } while (players < 1 || players > 4);
        for (int i = 0; i < players; i++) {
            System.out.print("Δώστε το όνομα του παίκτη " + (i + 1) + ": ");
            String name = scanner.next();
            if (!exist(name)) { //Ean den uparxei
                refugees.add(new Refugee(name, b1));
            } else {
                System.out.println("Το όνομα που δώσατε χρησιμοποιείται!");
                i--;
            }
        }
        //ΟΝΟΜΑΤΑ ΠΑΙΚΤΩΝ
        System.out.println();
        int index = 1;
        for (Refugee r : refugees) {
            System.out.println("Player " + (index++) + ": " + r.getName());
        }
        System.out.println();
    }

    public void play() {
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        //ARXH PAIXNIDIOY
        System.out.println("\nΠατήστε 'Enter' για να ξεκινήσει το παιχνίδι...\n");
        scanner.nextLine();
        while (index < refugees.size()) {
            currPlayer = refugees.get(index);                       
            if (currPlayer.getTurn() == false) {  //Αν δεν του έχει απαγορευτεί η σειρά
                System.out.println("Παίκτης: " + currPlayer.getName());
                RollDiceAction RDA = new RollDiceAction();
                RDA.act(currPlayer);
                int j = currPlayer.getCurrSqr().getSquareNumber();
                switch (j) {
                    case 8:
                    case 11:
                    case 14:
                    case 19:
                    case 24:
                    case 27:
                    case 32:
                    case 34:
                        System.out.println("Ο παίκτης " + currPlayer.getName() + " χάνει έναν γύρο! (ΜΗ ΥΛΟΠΟΙΗΣΙΜΟ)");
                        break;
                    case 9:
                    case 16:
                    case 26:
                    case 31:
//                    case 33:
                        {
                            Action action = currPlayer.getCurrSqr().returnAction(0);
                            action.act(currPlayer);
                            action = currPlayer.getCurrSqr().returnAction(1);
                            action.act(currPlayer);
                            break;
                        }
                    default:
                        {
                            Action action = currPlayer.getCurrSqr().returnAction(0);
                            action.act(currPlayer);
                            break;
                        }
                }
                if (currPlayer.getLife() == 0) {
                    refugees.remove(currPlayer);
                }
                System.out.println("Νέα θέση: " + currPlayer.getCurrSqr().getSquareNumber());
                System.out.println("Χρήματα παίκτη: " + currPlayer.getMoney() + "\nΖωές:" + currPlayer.getLife() + "\nΈξοδα παίκτη: " + currPlayer.getMoneyExpenses() + "\nNGO BANK: " + NGObank.getMoney() + "\nMAFIA BANK: " + MafiaBank.getMoney());                
                if (currPlayer.getWinner()) {
                    break;
                }
                System.out.println("\nΠατήστε 'Enter' για ρύψη ζαριού...\n");
                scanner.nextLine();

            }
            index++;
            if (index >= refugees.size()) {
                index = 0;
            }
        }
    }

    public void fillBoard() {
        TxtReader reader = new TxtReader();
        for (int i = 1; i < 41; i++) {
            reader.Reader(i);
            Squares sqr = new Squares(reader.getNum(), reader.getDescription(), reader.getText(), b1);
            b1.addSquare(sqr);
            switch (i-1) {
                case 0:break;
                case 1:
                    sqr.addAction(new PayMoneyAction(100, trash));
                    break;
                case 2:
                case 12:
                case 17:
                case 28:
                    sqr.addAction(new RollDiceAction());
                    break;
                case 3:
                    sqr.addAction(new PayMoneyAction(300, MafiaBank) );
                    break;
                case 4:
                case 5:
                case 15:
                case 18:
                case 23:
                case 25:
                case 29:
                case 30:
                case 35:
                case 38:
                    sqr.addAction(new GoToAction());
                    break;
                case 6:
                    sqr.addAction(new PayMoneyAction(1000, MafiaBank));
                    break;
                case 7:
                    sqr.addAction(new ExtraLifeAction());
                    break;
//                case 8:
//                case 11:
//                case 14:
//                case 19:
//                case 24:
//                case 27:
//                case 32:
//                case 34:
//                    sqr.addAction(new StayOneTurnAction());
//                    break;
                case 9:
                    sqr.addAction(new PayMoneyAction(3000, MafiaBank) );
                    sqr.addAction(new RollDiceAction());
                    break;
                case 10:
                    sqr.addAction(new LoseAction());
                    break;
                case 13:
                    sqr.addAction(new PayMoneyAction(200, MafiaBank));
                    break;
                case 16:
                    sqr.addAction(new PayMoneyAction(500, MafiaBank));
                    sqr.addAction(new RollDiceAction());
                    break;
                case 20:
                    sqr.addAction(new ReceiveMoneyAction(1000, NGObank));
                    break;
                case 21:
                    sqr.addAction(new PayMoneyAction(1500, trash));
                    break;
                case 22:
                    sqr.addAction(new BackRollDiceAction());
                    break;
                case 26:
                    sqr.addAction(new PayMoneyAction(1000, MafiaBank));
                    sqr.addAction(new OptionsAction());
                    break;
                case 31:
                    sqr.addAction(new PayMoneyAction(800, MafiaBank));
                    sqr.addAction(new RollDiceAction());
                    break;
                case 33:
//                    sqr.addAction(new GoToAction());
                    sqr.addAction(new RollDiceAction());
                    break;
                case 36:
                    sqr.addAction(new WinAction());
                    break;
                case 37:
                    sqr.addAction(new PayMoneyAction(1000, MafiaBank));
                    break;
                case 39:
                    sqr.addAction(new WinAction());
                    break;

            }
        }
    }

    private boolean exist(String name) {
        for (var r : refugees) {
            if (name.equalsIgnoreCase(r.getName())) {
                return true;
            }
        }
        return false;
    }
    
    private ArrayList getList(){
        return refugees;
    }
}
