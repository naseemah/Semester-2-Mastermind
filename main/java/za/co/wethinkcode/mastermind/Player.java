package za.co.wethinkcode.mastermind;

import java.io.InputStream;
import java.util.Scanner;

public class Player {
    private final Scanner inputScanner;
    private int guesses = 12;

    public Player(){
        this.inputScanner = new Scanner(System.in);
    }

    public Player(InputStream inputStream){
        this.inputScanner = new Scanner(inputStream);
    }

    /**
     * Gets a guess from user via text console.
     * This must prompt the user to re-enter a guess until a valid 4-digit
     * string is entered, or until the user enters `exit` or `quit`.
     *
     * @return the value entered by the user
     */

        public String getGuess () {
            boolean end = true;
            String input = null;
            
            while (end){
                System.out.println("Input 4 digit code:");
                input = inputScanner.nextLine(); //gets users input

                if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
                    end = false;

                }
                else{
                    if (input.length() == 4){
                        for (int i = 0; i < 4; i++){
                            if (Character.isDigit(input.charAt(i)) &&
                                    Character.getNumericValue(input.charAt(i)) >0 &&
                                    Character.getNumericValue(input.charAt(i)) <9){
                                end = false;
                            }else {
                                end = true;
                                System.out.println("Please enter exactly 4 digits (each from 1 to 8).");
                                break;
                            }
                        }
                    }else{
                        System.out.println("Please enter exactly 4 digits (each from 1 to 8).");
                    }
                }
            }
            return input;
        }

    public int getGuesses() {
        return guesses;
    }

    public void setGuesses(int guesses) {
        this.guesses = guesses;
    }
}
