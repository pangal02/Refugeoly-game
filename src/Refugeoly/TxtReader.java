package Refugeoly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TxtReader {

    private int num;
    private String description, text, trash;

    public void Reader(int z) {
        
        try {
            File file = new File("refugeoly-squares.txt");
            Scanner scanner = new Scanner(file);
            for(int i = 0; i < z; i++){
                String line = scanner.nextLine();
                    num = Integer.parseInt(line);
                    line = scanner.nextLine();
                    description = line;
                    line = scanner.nextLine();
                    text = line;
                    if (scanner.hasNextLine()){
                        line = scanner.nextLine();
                        trash = line;
                    }
            }
            // scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getNum() {
        return num;
    }

    public String getDescription() {
        return description;
    }

    public String getText() {
        return text;
    }
//
//    public int lineCal(String fileName) {
//        try {
//            File file = new File(fileName);
//            Scanner scanner = new Scanner(file);
//
//            int k = 0;
//            while (scanner.hasNextLine()) {
//                scanner.nextLine();
//                k++;
//            }
//            return k;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return e.hashCode();
//        }
//    }
}