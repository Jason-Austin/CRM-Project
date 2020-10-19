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
            System.out.println("Enter an option (1, 2, 3, 4 or 0):");

            String userDestination = input.getString();

    //VIEW ALL CONTACTS

            if (userDestination.equalsIgnoreCase("1")) {
                System.out.println("Would you like to view all contacts? Y/N");

                String userConfirm = input.getString();

                boolean viewContacts = true;

                if (userConfirm.equalsIgnoreCase("y")) {
                    System.out.printf("   %-15s| %-12s |\n", "Name","Phone Number");
                    System.out.println("----------------------------------");
                    FileIO.printFileContents(dataFilePath);
                }
                while (viewContacts) {
                    System.out.println("\nWould you like to return to main menu? y/n");
                    String viewConfirm = input.getString();

                    if (viewConfirm.equalsIgnoreCase("y")) {
                        viewContacts = false;
                    } else {
                        FileIO.printFileContents(dataFilePath);
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
                            System.out.println("Would you like to return to main menu? y/n");
                            String userConfirm = input.getString();

                            if (userConfirm.equalsIgnoreCase("y")) {
                                yesEnter = false;
                                System.out.println("\nReturning to main menu\n");
                            }
                        }
                    } else {
                        yesEnter = false;
                        System.out.println("\nReturning to main menu\n");
                    }
                }
            }


            //SEARCH FOR NAME
            else if (userDestination.equalsIgnoreCase("3")) {

                boolean yesSearch = true;

                while (yesSearch) {
                    System.out.println("Enter name you would like to search for");
                    String userSearch = input.getString();
                    DatabaseModifier.searchContact(dataFilePath, userSearch);

                    System.out.println("Would you like to search a new name? y/n");
                    String confirm = input.getString();

                    if (!confirm.equalsIgnoreCase("y")) {
                        System.out.println("Would you like to return to main menu? Y/N");

                        String userConfirm = input.getString();
                        if (userConfirm.equalsIgnoreCase("y")) {
                            yesSearch = false;
                            System.out.println("\nReturning to main menu\n");
                        }
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
                        System.out.println("Would you like to return to main menu? Y/N");

                        String userConfirm = input.getString();
                        if (userConfirm.equalsIgnoreCase("y")) {
                            yesDelete = false;
                            System.out.println("\nReturning to main menu\n");
                        }
                    }
                }
            } else if (userDestination.equalsIgnoreCase("0")){
                start = false;
            }

            // WILL DELETE ENTIRE LIST
//        DatabaseModifier.clearList(dataFilePath);

        }
    }


}
