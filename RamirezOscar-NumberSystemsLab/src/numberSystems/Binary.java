package numberSystems;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The Binary class will prompt the user for a 32-bit binary digit, convert
 * to either decimal or hexadecimal, and print the result to the user and output
 * file.
 * @author Oscar Ramirez
 * @version 1/31/20
 *
 */
public class Binary {
    PrintWriter out;
    Scanner in;
    StringBuilder bin;
    int dec;
    StringBuilder hex;
    private final int DEC_FLAG = 0;
    private final int HEX_FLAG = 1;
    
    public Binary(PrintWriter out)
    {
        this.out = out;
        in = new Scanner(System.in);
        bin = new StringBuilder();
        dec = -1;
        hex = new StringBuilder();
    }
    
    public void binToDec()
    {
        inputBin();
        convert(DEC_FLAG);
        display(DEC_FLAG);
    }

    public void binToHex()
    {
        inputBin();
        convert(HEX_FLAG);
        addFlag();
        display(HEX_FLAG);
    }
    
    private void inputBin()
    {
        String input = getInput();
        while (!isValidInput(input)) {
            input = getInput();
        }
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
        String promptSelectionMessage = "Enter a 32-bit binary digit: ";
        System.out.print(promptSelectionMessage);
        out.print(promptSelectionMessage);
    }
    
    private Boolean isValidInput(String input)
    {
        Boolean isValidInput;
        processInput(input);
        if (bin.length() == Integer.SIZE) {
            isValidInput = true;
        }
        else {
            displayError();
            isValidInput = false;
        }
        return isValidInput;
    }
        
    private void processInput(String input)
    {
        input = input.trim();
        input = input.replaceAll("\\s", "");
        bin = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0' || input.charAt(i) == '1') {
                bin.append(input.charAt(i));
            }
        }
    }

    private void displayError()
    {
        String errorMessage = "Input is not a 32-bit binary digit.";
        System.out.println(errorMessage);
        out.println(errorMessage);
    }
    
    private void convert(int flag)
    {
        if (flag == DEC_FLAG) {
            bin.reverse();
            int sum = 0;
            for (int i = 0; i < bin.length(); i++) {
                if (bin.charAt(i) == '1') {
                    sum += Math.pow(2, i);
                }
            }
            bin.reverse();
            dec = sum;
        }
        else {
            hex = new StringBuilder();
            for (int i = 0; i < Integer.SIZE; i += 4) {
                switch (bin.substring(i, i + 4)) {
                case "0000": hex.append("0"); break;
                case "0001": hex.append("1"); break;
                case "0010": hex.append("2"); break;
                case "0011": hex.append("3"); break;
                case "0100": hex.append("4"); break;
                case "0101": hex.append("5"); break;
                case "0110": hex.append("6"); break;
                case "0111": hex.append("7"); break;
                case "1000": hex.append("8"); break;
                case "1001": hex.append("9"); break;
                case "1010": hex.append("A"); break;
                case "1011": hex.append("B"); break;
                case "1100": hex.append("C"); break;
                case "1101": hex.append("D"); break;
                case "1110": hex.append("E"); break;
                case "1111": hex.append("F"); break;
                }
            }
        }
    }
    
    private void addFlag()
    {
        hex.insert(0, "Ox");
    }
    
    private void display(int flag)
    {
        String displayMessage;
        addSpaces();
        if (flag == DEC_FLAG) {
            displayMessage = String.format(
                    "%s converted to decimal is: %d%n",
                    bin.toString(), dec);
        }
        else {
            displayMessage = String.format(
                    "%s converted to hexadecimal is: %s%n",
                    bin.toString(), hex.toString());
        }
        System.out.println(displayMessage);
        out.println(displayMessage);
    }
    
    private void addSpaces()
    {
        int nibble_size = 4;
        for (int i = bin.length() - nibble_size; i >= nibble_size;
                i -= nibble_size) {
            bin.insert(i, " ");
        }
    }
}
