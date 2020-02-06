/*
 * 1. Ask Finn how many cousins he has – they will be the potential dates.
 * 2. Then ask for their names, storing his answers in an ArrayList. Display the list.
 * 3. Ask Finn who his best looking cousin is. Delete this person from the list. Display the list.
 * 4. Then add Jennifer Lopez to the end of the list. Display the list.
 * 5. Then, ask Finn which cousin has the best teeth, and also what his sister’s name is. Replace that cousin with the sister. Display the list.
 * 6. Then, ask Finn how old each person on the list is (ex: “How old is Jennifer Lopez?”). Insert each person’s age immediately after that person’s name in the List. Display the list.
 * 
 * Note: You must make print the ArrayList with a loop. There will only be ONE ArrayList. Further, that ArrayList will be twice the number of people since the list must accommodate each person's age.
 *
 * Adam Browning
 * 2/4/2020
 */

import java.util.ArrayList;
import java.util.Scanner;
public class FinnzDatingService
{
    public static void main() {
        ArrayList<String> nameList = new ArrayList<String>();        
        Scanner input = new Scanner(System.in);
        String response = "";

        System.out.print("\f      FINNZ DATING SERVICE\n\n");

        while (true) {
            System.out.print("Finn, how many cousins do you have? ");
            response = input.nextLine();
            if (response.matches("^[0-9]*$")) {
                break;
            } else {
                System.out.print("\f        FINNZ DATING SERVICE\n\nYou can only input a number!\n\n");
            }
        }

        System.out.print("\f      FINNZ DATING SERVICE\n\n");

        for (int i = 0; i < Integer.parseInt(response); i++) {
            System.out.print("What is the name of cousin #" + (i+1) + "? ");
            nameList.add(input.nextLine().toLowerCase());
        }

        printArray(nameList);

        while (true) {
            System.out.print("Finn, who is your best looking cousin? ");
            response = input.nextLine().toLowerCase();
            if (nameList.contains(response)) {
                nameList.remove(response);
                break;
            } else {
                System.out.print("NOT A PERSON\n\n");
            }
        }
        printArray(nameList);
        
        nameList.add("Jenifer Lopez");
        
        printArray(nameList);
        
    }

    public static void printArray(ArrayList<String> array) {
        for (String names: array) {
            System.out.print(names + "\n");
        }
    }
}

