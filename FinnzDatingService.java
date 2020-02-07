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
        String numCousins = "";

        System.out.print("\f      FINNZ DATING SERVICE\n\n");

        while (true) {
            System.out.print("Finn, how many cousins do you have? ");
            numCousins = input.nextLine();
            if (numCousins.matches("^[0-9]*$")) {
                break;
            } else {
                System.out.print("\f      FINNZ DATING SERVICE\n\nYou can only input a number!\n\n");
            }
        }

        System.out.print("\f      FINNZ DATING SERVICE\n\n");

        for (int i = 0; i < Integer.parseInt(numCousins); i++) {
            while (true) {
                System.out.print("What is the name of cousin #" + (i+1) + "? ");
                String response1 = input.nextLine();
                if (response1.toLowerCase().matches("^[\\p{L} .'-]+$") && !(nameList.contains(response1))) {
                    nameList.add(response1.toLowerCase());
                    System.out.print("\f      FINNZ DATING SERVICE\n\n");
                    break;
                } else {
                    System.out.print("\f      FINNZ DATING SERVICE\n\nThe name can only be letters and cannot be on the list!\n\n");
                }   
            }
        }
        printInfo(nameList);  

        while (true) {
            System.out.print("Finn, who is your best looking cousin? ");
            response = input.nextLine().toLowerCase();
            if (nameList.contains(response)) {
                nameList.remove(response);
                break;
            } else {
                printInfo(nameList);  
                System.out.print("The name can only be one in the list!\n\n");
            }
        }
        nameList.add("jennifer lopez");
        printInfo(nameList);  

        while (true) {
            System.out.print("Finn, which cousin has the best teeth? ");
            response = input.nextLine().toLowerCase();
            if (nameList.contains(response)) {
                break;
            } else {
                printInfo(nameList);  
                System.out.print("The name can only be one in the list!\n\n");
            }
        }

        printInfo(nameList);

        while (true) {
            System.out.print("What is your sisters name? ");
            String response2 = input.nextLine();
            if (response2.toLowerCase().matches("^[\\p{L} .'-]+$") && !(nameList.contains(response2))) {
                nameList.set(nameList.indexOf(response), response2);
                break;
            } else {    
                printInfo(nameList); 
                System.out.print("The name can only contain letters and cannot be on the list!\n\n");                
            }   
        }

        printInfo(nameList);  

        for (int i = 0; i < Integer.parseInt(numCousins)*2; i = i+2) {
            while (true) {
                printInfo(nameList);
                System.out.print("How old is " + nameList.get(i) + "? ");
                String age = input.nextLine();
                if (age.toLowerCase().matches("^[0-9]*$")) {
                    nameList.add(nameList.indexOf(nameList.get(i))+1, age);
                    System.out.print("\f      FINNZ DATING SERVICE\n\n");
                    break;
                } else {
                    System.out.print("\f      FINNZ DATING SERVICE\n\nThe age must be a number!\n\n");
                }   
            }
        }
        printInfo(nameList);
    }

    public static void printArray(ArrayList<String> array) {
        for (String names: array) {
            if (names.matches("^[0-9]*$")) {
                System.out.print(" - Age: " + names);
            } else {
                System.out.print("\n" + names);
            }
        }
    }

    public static void printInfo(ArrayList<String> nameList) {
        System.out.print("\f      FINNZ DATING SERVICE\n\nList of names:");
        printArray(nameList);   
        System.out.println("\n"); 
    }
}