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
            System.out.println("1-View all Contacts");
            System.out.println("2-Add new Contact");
            System.out.println("3-Search contact by name");
            System.out.println("4-Delete existing contact");
            System.out.println("0-Exit");

            String userDestination = input.getString();

    //VIEW ALL CONTACTS

            if (userDestination.equalsIgnoreCase("1")) {
                System.out.println("Would you like to view all contacts? Y/N");
                String userConfirm = input.getString();

                boolean viewContacts = true;

                if (userConfirm.equalsIgnoreCase("y")) {
                    FileIO.printFileContents(dataFilePath);
                }
                while (viewContacts) {
                    System.out.println("\nWould you like to return to main menu? y/n");
                    String viewConfirm = input.getString();
                    if (viewConfirm.equalsIgnoreCase("y")) {
                        viewContacts = false;
                    }
                }
            }

//         ADD NEW CONTACT

            else if (userDestination.equalsIgnoreCase("2")) {
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
                            System.out.println("\nReturning to main menu\n");
                            yesEnter = false;
                        }
                    } else {
                        System.out.println("Returning to main menu\n");
                        yesEnter = false;

                    }
                }
            } else if (userDestination.equalsIgnoreCase("0")){
                start = false;
            }

            //SEARCH FOR NAME
            else if (userDestination.equalsIgnoreCase("3")) {

                boolean yesSearch = true;

                System.out.println("Enter name you would like to search for");

                while (yesSearch) {

                    String userSearch = input.getString();
                    DatabaseModifier.searchContact(dataFilePath, userSearch);

                    System.out.println("Would you like to search a new name? y/n");
                    String confirm = input.getString();
                    if (!confirm.equalsIgnoreCase("y")) {
                        System.out.println("\nReturning to main menu");
                        yesSearch = false;
                    }
                }
            }

            // DELETE Existing contact

            else if (userDestination.equalsIgnoreCase("4")) {

                boolean yesDelete = true;

                while (yesDelete) {
                    System.out.println("Enter name of user to delete");
                    String deleteUser = input.getString();

                    DatabaseModifier.deleteContact(dataFilePath, deleteUser);
                    System.out.printf("%s has been deleted from the contact list\n", deleteUser);

                    System.out.println("Would you like to delete another user? y/n");
                    String confirm = input.getString();
                    if (!confirm.equalsIgnoreCase("y")) {
                        System.out.println("Would you like to return to main menu? y/n");
                        System.out.println("\nReturning to main menu\n");
                        yesDelete = false;
                    }
                }
            }

            // WILL DELETE ENTIRE LIST
//        DatabaseModifier.clearList(dataFilePath);

        }
    }


}
