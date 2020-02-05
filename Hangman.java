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
        char guess;
        boolean win = false;

        ArrayList<Character> word = new ArrayList<Character>();
        ArrayList<Character> guessedLetters = new ArrayList<Character>();

        Scanner input = new Scanner (System.in);

        System.out.println("\f        HANGMAN\n\n");

        System.out.print("Player 1 -  Enter the word for player 2 to guess: ");
        stringWord = input.nextLine().toLowerCase();

        while (true) {
            if (stringWord.matches("([a-zA-Z])") || !(stringWord.matches("([\\S])"))) {
                if (stringWord.trim().isEmpty()) {
                    System.out.print("\f        HANGMAN\n\nThe word can only contain letters and spaces\n");
                } else 
                    break;
            } else {
                System.out.print("\f        HANGMAN\n\nThe word can only contain letters and spaces\n");
            }

            System.out.print("Player 1 -  Enter the word for player 2 to guess: ");
            stringWord = input.nextLine().toLowerCase();
        }
    }
}
