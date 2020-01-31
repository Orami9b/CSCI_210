package numberSystems;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The Menu class displays the options from which the user may select, and
 *    prompts the user for input.
 * @author Oscar Ramirez
 * @version 1/29/20
 * 
 */
public class Menu
{
    PrintWriter out;
    Scanner in;
    
    /**
     * Creates a Menu object with a reference to a PrintWriter object used for
     * and initializes a Scanner object used for input
     * @param out the PrintWriter object used for output
     */
    public Menu(PrintWriter out)
    {
        this.out = out;
        in = new Scanner(System.in);
    }
    
    /**
     * Displays a menu with options from which the user will choose
     */
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
    
    /**
     * A sentinel value used for exiting the menu. Set to 7.
     */
    private final int EXIT_VALUE = 7;
    /**
     * Prompts the user for input, checking that it's within range (1 - 7). When
     * sentinel value is selected, the method will stop prompting the user and
     * will close the Scanner object created at initialization.
     * @return an integer 1 - 7 from user input
     */
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
    
    /**
     * Prompts the user for input and returns next line from input as a String.
     * @return next line from input as a String
     */
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
    
    /**
     * Prints a prompt message to the user and output file.
     */
    private void promptSelection()
    {
        String promptSelectionMessage = "Enter an option (1 - 7): ";
        System.out.print(promptSelectionMessage);
        out.print(promptSelectionMessage);
    }
    
    /**
     * Checks if a given input is valid: an integer, and in range (1 - 7)
     * @param input the input from user when prompted
     * @return true if input is valid, otherwise false
     */
    private Boolean isValidInput(String input)
    {
        Boolean isValidInput = true;
        
        try {
            int value = Integer.parseInt(input);
            if (value < 1 || value > EXIT_VALUE) {
                String errorMessage = "Input is not 1 - 7.";
                displayError(errorMessage);
                isValidInput = false;
            }
        }
        catch (NumberFormatException exception) {
            String errorMessage = "Input is not an integer.";
            displayError(errorMessage);
            isValidInput = false;
        }
        return isValidInput;
    }
    
    /**
     * Prints an error message to the user and output file
     * @param errorMessage the error the user encountered during input
     */
    private void displayError(String errorMessage)
    {
        System.out.println(errorMessage);
        out.println(errorMessage);
    }
    
    /**
     * Prints a goodbye message to the user and output file, when the menu is
     * finished being used
     */
    private void displayGoodbye()
    {
        String goodbye = "Thank you. Goodbye!";
        System.out.print(goodbye);
        out.print(goodbye);
    }
}
