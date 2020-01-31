package numberSystems;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author oscar
 *
 */
public class Menu
{
    PrintWriter out;
    Scanner in;
    
    public Menu(PrintWriter out)
    {
        this.out = out;
        in = new Scanner(System.in);
    }
    
    public void display()
    {
        String[] displayOptions = 
            {"Number Systems Lab: A Conversion Program",
             "1. Decimal to Binary",
             "2. Decimal to Hexadecimal",
             "3. Binary to Decimal",
             "4. Binary to Hexadecimal",
             "5. Hexadecimal to Decimal",
             "6. Hexadecimal to Binary",
             "7. Exit"};
        for (int i = 0; i < displayOptions.length; i++) {
            System.out.println(displayOptions[i]);
            out.println(displayOptions[i]);
        }
    }
    private final int EXIT_VALUE = 7;
    public int getSelection()
    {
        String input = getInput();
        while(!isValidInput(input)) {
            input = getInput();
        }
        int selection = Integer.parseInt(input);
        if (selection == EXIT_VALUE) {
            displayGoodbye();
            in.close();
        }
        return selection;
    }
    
    private String getInput()
    {
        promptSelection();
        String input = "";
        if (in.hasNextLine()) {
            input = in.nextLine();
            out.println(input);
        }
        return input;
    }
    
    private void promptSelection()
    {
        String promptSelectionMessage = "Enter an option (1 - 7): ";
        System.out.print(promptSelectionMessage);
        out.print(promptSelectionMessage);
    }
    
    private Boolean isValidInput(String input)
    {
        Boolean isValidInput = true;
        
        try {
            int value = Integer.parseInt(input);
            if (value < 1 || value > EXIT_VALUE) {
                String errorMessage = "Input was not 1 - 7.";
                displayError(errorMessage);
                isValidInput = false;
            }
        }
        catch (Exception NumberFormatException) {
            String errorMessage = "Input was not an integer.";
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
    
    private void displayGoodbye()
    {
        String goodbye = "Thank you. Goodbye!";
        System.out.println(goodbye);
        out.println(goodbye);
    }
}
