package numberSystems;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The Decimal class will prompt the user for a decimal number, convert
 * to either binary or hexadecimal, and print the result to the user and output
 * file.
 * @author Oscar Ramirez
 * @version 1/30/20
 *
 */
public class Decimal
{
    private PrintWriter out;
    private Scanner in;
    private int dec;
    private StringBuilder bin;
    private int nibble;
    private StringBuilder hex;
    
    public Decimal(PrintWriter out)
    {
        this.out = out;
        in = new Scanner(System.in);
        dec = -1;
        bin = new StringBuilder(Integer.SIZE);
        nibble = 4;
        hex = new StringBuilder(nibble);
    }
    
    public void decToBin()
    {
        inputDec();
        toBin();
        formatBin();
        displayBin();
    }

    private void inputDec()
    {
        String input = getInput();
        while (!isValidInput(input)) {
            input = getInput();
        }
        dec = Integer.parseInt(input);
    }
    
    private String getInput()
    {
        promptInput();
        String input = "";
        if (in.hasNextLine()) {
            input = in.nextLine();
            out.println(input);
        }
        return input;
    }
    
    private void promptInput()
    {
        String promptSelectionMessage = "Enter a decimal number: ";
        System.out.print(promptSelectionMessage);
        out.print(promptSelectionMessage);
    }
    
    private Boolean isValidInput(String input)
    {
        Boolean isValidInput = true;
        
        try {
            Integer.parseUnsignedInt(input);
        }
        catch (NumberFormatException exception) {
            String errorMessage = "Input is not an unsigned integer.";
            displayError(errorMessage);
            isValidInput = false;
        }
        return isValidInput;
    }
    
    private void displayError(String errorMessage)
    {
        System.out.println(errorMessage);
        out.println(errorMessage);
    }
    
    private void toBin()
    {
        int value = dec;
        bin = new StringBuilder(Integer.SIZE);
        while (value != 0) {
            bin.append(value % 2);
            value /= 2;
        }
    }
    
    private void formatBin()
    {
        fillBin();
        bin = bin.reverse();
        addSpaces();
    }
    
    private void fillBin()
    {
        while(bin.length() < Integer.SIZE) {
            bin.append(0);
        }
    }
    
    private void addSpaces()
    {
        for (int i = bin.length() - nibble; i >= nibble; i -= nibble) {
            bin.insert(i, " ");
        }
    }
    
    private void displayBin()
    {
        String displayMessage = String.format(
                "%d converted to binary is: %s%n", dec, bin.toString());
        System.out.println(displayMessage);
        out.println(displayMessage);
    }
    
    public void decToHex()
    {
        inputDec();
        toHex();
        outHex();
    }
    
    private void toHex()
    {
        
    }
    
    private void outHex()
    {
        
    }
}
