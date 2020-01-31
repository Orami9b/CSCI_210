package numberSystems;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Project Title: Number Systems Lab
 * Project Description: An interactive program that converts numbers from 
 *     decimal, binary or hexadecimal to any other base given user input.
 * Version or Date: 1/29/20 
 * Author: Oscar Ramirez
 * Palomar ID: 008263240
 * User Instructions: Interact with prompts as directed.
 */
public class Driver {
    public static void main(String[] args) throws IOException{
        int choice;
        
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        Decimal dec = new Decimal(pw);
        Binary bin = new Binary(pw);
        Hexadecimal hex = new Hexadecimal(pw);
        Menu menu = new Menu(pw);
        
        do {
            menu.display();
            choice = menu.getSelection();
            switch(choice) {
            case 1 : dec.decToBin(); break;
            case 2 : dec.decToHex(); break;
            case 3 : bin.binToDec(); break;
            case 4 : bin.binToHex(); break;
            case 5 : hex.hexToDec(); break;
            case 6 : hex.hexToBin(); break;
            }
        } while (choice != 7);
        pw.close();
    }
}
