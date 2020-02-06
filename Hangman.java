    /*
 * Design the simple game hangman. Ten misses.
 * Hint, make two arrays one with the word and the other with incorrect guesses.
 * 
 * Should look something like this:
 * Pick a letter: M Letter Picked: Q, G
 * M _ _ _ _ _
 *
 * Adam Browning
 * 2/4/2020
 */

import java.util.ArrayList;
import java.util.Scanner;
public class Hangman
{
    public static void main() {
        int guessesLeft = 10;
        String stringWord;
        String guess;
        int guessNumber = 0;
        boolean end = false;

        ArrayList<Character> word = new ArrayList<Character>();
        ArrayList<Character> guessedLetters = new ArrayList<Character>();
        ArrayList<Character> display = new ArrayList<Character>();

        Scanner input = new Scanner (System.in);

        System.out.println("\f        HANGMAN\n\n");

        System.out.print("Enter a word: ");
        stringWord = input.nextLine().toLowerCase();

        while (true) {
            if (stringWord.matches("^[\\p{L} .'-]+$")) {
                if (stringWord.trim().isEmpty()) {
                    System.out.print("\f        HANGMAN\n\nThe word can only contain letters and spaces\n");
                } else 
                    break;
            } else {
                System.out.print("\f        HANGMAN\n\nThe word can only contain letters and spaces\n");
            }

            System.out.print("Enter a word: ");
            stringWord = input.nextLine().toLowerCase();
        }

        for (int i = 0; i < stringWord.length(); i++) {
            if (stringWord.charAt(i) == ' '){
                display.add(' ');
            } else {
                display.add('_');
            }
            word.add(stringWord.charAt(i));
        }        

        System.out.print("\f        HANGMAN\n\nGame Started\n\n");

        while (end == false) {  
            System.out.print("Guesses Left: " + guessesLeft + "\nLetters Guessed: ");

            for (char letters: guessedLetters) {
                System.out.print(letters + ", ");
            }

            System.out.print("\n\n");

            for (char character: display) {
                System.out.print(character + " ");
            }

            System.out.print("\n\nGuess a letter: ");
            guess = input.nextLine();
            if (guess.length() == 1 && (guess.matches("([a-zA-Z])")) && !(guessedLetters.contains(guess.charAt(0)))) {
                if (word.contains(guess.charAt(0))) {
                    for (int i = 0; i < stringWord.length(); i++) {
                        if (word.get(i) == guess.charAt(0)) {
                            display.set(i, guess.charAt(0));                             
                        } 
                    }
                    System.out.print("\f        HANGMAN\n\nCorrect Guess\n\n");
                } else {
                    guessesLeft--;                    
                    if (guessesLeft < 1) {
                        end = true;
                    }                    
                    System.out.print("\f        HANGMAN\n\nIncorrect Guess\n\n");
                }
                guessedLetters.add(guess.charAt(0));   
                guessNumber++;
            } else {
                System.out.print("\f        HANGMAN\n\nNot a valid guess. That is already guessed or that is not one letter\n\n");
            }
            if (display.equals(word)) {
                end = true;
            }   
        }

        System.out.print("Guesses Left: " + guessesLeft + "\nLetters Guessed: ");

        for (int i = 0; i < guessedLetters.size(); i++) {
            if (i != (guessNumber - 1)) {
                System.out.print(guessedLetters.get(i) + ", ");
            } else {
                System.out.print(guessedLetters.get(i));
            }
        }

        System.out.print("\n\n");

        if (guessesLeft < 1) {
            System.out.print("Answer: ");
            for (char letters: word) {
                System.out.print(letters + " ");
            }

            System.out.print("\n\nYou ran out of guesses!");
        } else {
            for (char letters: word) {
                System.out.print(letters + " ");
            }
            System.out.print("\n\nYou win!");
        }
    }
}

