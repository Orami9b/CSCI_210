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
    private StringBuilder hex;
    private final int BIN_FLAG = 0;
    private final int HEX_FLAG = 1;
    
    public Decimal(PrintWriter out)
    {
        this.out = out;
        in = new Scanner(System.in);
        dec = -1;
        bin = new StringBuilder();
        hex = new StringBuilder();
    }
    
    public void decToBin()
    {
        inputDec();
        convert(BIN_FLAG);
        format(BIN_FLAG);
        display(BIN_FLAG);
    }

    public void decToHex()
    {
        inputDec();
        convert(HEX_FLAG);
        format(HEX_FLAG);
        display(HEX_FLAG);
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
            displayError();
            isValidInput = false;
        }
        return isValidInput;
    }
    
    private void displayError()
    {
        String errorMessage = "Input is not an unsigned integer.";
        System.out.println(errorMessage);
        out.println(errorMessage);
    }
    
    private void convert(int flag)
    {
        if (flag == BIN_FLAG) {
            int value = dec;
            reset(flag);
            while (value != 0) {
                bin.append(value % 2);
                value /= 2;
            }
        }
        else {
            int value = dec;
            reset(flag);
            int hexBase = 16;
            while (value != 0) {
                hex.append(nextHexDigit(value));
                value /= hexBase;
            }
        }
    }

    private void reset(int flag)
    {
        if (flag == BIN_FLAG) {
            bin = new StringBuilder(Integer.SIZE);
        }
        else {
            hex = new StringBuilder();
        }
    }
    
    private String nextHexDigit(int hex) {
        String nextHexDigit = "";
        switch (hex % 16) {
        case 1 : nextHexDigit = "1"; break;
        case 2 : nextHexDigit = "2"; break;
        case 3 : nextHexDigit = "3"; break;
        case 4 : nextHexDigit = "4"; break;
        case 5 : nextHexDigit = "5"; break;
        case 6 : nextHexDigit = "6"; break;
        case 7 : nextHexDigit = "7"; break;
        case 8 : nextHexDigit = "8"; break;
        case 9 : nextHexDigit = "9"; break;
        case 10 : nextHexDigit = "A"; break;
        case 11 : nextHexDigit = "B"; break;
        case 12 : nextHexDigit = "C"; break;
        case 13 : nextHexDigit = "D"; break;
        case 14 : nextHexDigit = "E"; break;
        case 15 : nextHexDigit = "F"; break;
        }
        return nextHexDigit;
    }
    
    private void format(int flag)
    {
        if (flag == BIN_FLAG) {
            fill(BIN_FLAG);
            bin = bin.reverse();
            addSpaces();
        }
        else {
            fill(HEX_FLAG);
            hex = hex.reverse();
            addFlag();
        }
    }
    
    private void fill(int flag)
    {
        if (flag == BIN_FLAG) {
            while(bin.length() < Integer.SIZE) {
                bin.append(0);
            }
        }
        else {
            int hexSize = 8;
            while(hex.length() < hexSize) {
                hex.append(0);
            }
        }
    }

    private void addSpaces()
    {
        int nibbleSize = 4;
        for (int i = bin.length() - nibbleSize; i >= nibbleSize;
                i -= nibbleSize) {
            bin.insert(i, " ");
        }
    }
    
    private void addFlag()
    {
        hex.insert(0, "0x");
    }
    
    private void display(int flag)
    {
        String displayMessage;
        if (flag == BIN_FLAG) {
            displayMessage = String.format(
                    "%d converted to binary is: %s%n",
                    dec, bin.toString());
        }
        else {
            displayMessage = String.format(
                    "%d converted to hexadecimal is: %s%n",
                    dec, hex.toString());
        }
        System.out.println(displayMessage);
        out.println(displayMessage);
    }
}
