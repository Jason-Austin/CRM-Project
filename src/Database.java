import files.FileIO;
import util.Input;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Database {


    public static void main(String[] args) throws IOException {
        String directoryName = "Contacts";
        String fileName = "Contacts.txt";

        boolean start = true;


        Path dataFilePath = FileIO.createDirectoryAndFile(directoryName, fileName);

        Input input = new Input();


        while (start) {
            System.out.println("Welcome to the Contact List\n");
            System.out.println("1-View Contacts");
            System.out.println("2-Add new Contact");
            System.out.println("3-Search contact by name");
            System.out.println("4-Delete existing contact");
            System.out.println("0-Exit");

            String userDestination = input.getString();

            //VIEW ALL CONTACTS
            System.out.println("Would you like to view all contacts? Y/N");
            String userConfirm = input.getString();

            boolean viewContacts = true;

            if (userConfirm.equalsIgnoreCase("y")) {
                FileIO.printFileContents(dataFilePath);
            }
            while (viewContacts){
                System.out.println("Would you like to return to main menu?");
                String viewConfirm = input.getString();
                if (viewConfirm.equalsIgnoreCase("y")){
                    viewContacts = false;
                }
            }


//         ADD NEW CONTACT
                System.out.println("Would you like to enter a New contact? Y/N");
            String userInput = input.getString();

            Boolean yesEnter = true;

            while (yesEnter) {
                if (userInput.equalsIgnoreCase("y")) {
                    System.out.println("please enter Name");
                    String name = input.getString();

                    System.out.println("Please enter Phone Number");
                    String phoneNumber = input.getString();

                    DatabaseModifier.addContact(dataFilePath, name, phoneNumber);
                    FileIO.printFileContents(dataFilePath);

                    System.out.println("Would you like to enter a new name? y/n");
                    String confirm = input.getString();
                    if (!confirm.equalsIgnoreCase("y")) {
                        System.out.println("Returning to main menu");
                        yesEnter = false;
                    }
                } else {
                    FileIO.printFileContents(dataFilePath);
                    yesEnter = false;
                }
            }


            //SEARCH FOR NAME
//        DatabaseModifier.searchContact(dataFilePath, "Jason");

//        DatabaseModifier.deleteContact(dataFilePath, "bill");


            //PRINT ENTIRE LIST
//        FileIO.printFileContents(dataFilePath);

            // WILL DELETE ENTIRE LIST
//        DatabaseModifier.clearList(dataFilePath);

        }
    }


}
