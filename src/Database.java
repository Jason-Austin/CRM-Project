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
            System.out.println(DatabaseModifier.ANSI_BLUE + "\nWelcome to the Contact List\n" + DatabaseModifier.ANSI_RESET);
            System.out.println("1-View all Contacts");
            System.out.println("2-Add new Contact");
            System.out.println("3-Search contact by name");
            System.out.println("4-Delete existing contact");
            System.out.println("0-Exit");
            System.out.println(DatabaseModifier.ANSI_GREEN + "Enter an option (1, 2, 3, 4 or 0):" + DatabaseModifier.ANSI_RESET);

            String userDestination = input.getString();

    //VIEW ALL CONTACTS

            if (userDestination.equalsIgnoreCase("1")) {
                System.out.println(DatabaseModifier.ANSI_GREEN + "Would you like to view all contacts? y/n" + DatabaseModifier.ANSI_RESET);

                String userConfirm = input.getString();

                boolean viewContacts = true;

                if (userConfirm.equalsIgnoreCase("y")) {
                    System.out.printf("   %-15s| %-12s |\n", "Name","Phone Number");
                    System.out.println("----------------------------------");
                    FileIO.printFileContents(dataFilePath);
                }
                while (viewContacts) {
                    System.out.println(DatabaseModifier.ANSI_YELLOW + "\nWould you like to return to main menu? y/n" + DatabaseModifier.ANSI_RESET);
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
                System.out.println(DatabaseModifier.ANSI_YELLOW + "Would you like to enter a New contact? y/n" + DatabaseModifier.ANSI_RESET);
                String userInput = input.getString();

                Boolean yesEnter = true;

                while (yesEnter) {
                    if (userInput.equalsIgnoreCase("y")) {
                        System.out.println(DatabaseModifier.ANSI_GREEN + "Please enter Name" + DatabaseModifier.ANSI_RESET);
                        String name = input.getString();

                        System.out.println(DatabaseModifier.ANSI_GREEN + "Please enter Phone Number" + DatabaseModifier.ANSI_RESET);
                        String phoneNumber = input.getString();

                         DatabaseModifier.addContact(dataFilePath, name, phoneNumber);

                        System.out.println(DatabaseModifier.ANSI_YELLOW + "\nWould you like to another contact? y/n" + DatabaseModifier.ANSI_RESET);
                        String confirm = input.getString();

                        if (!confirm.equalsIgnoreCase("y")) {
                            System.out.println(DatabaseModifier.ANSI_YELLOW + "\nWould you like to return to main menu? y/n" + DatabaseModifier.ANSI_RESET);
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
                    System.out.println(DatabaseModifier.ANSI_GREEN + "Enter name you would like to search for" + DatabaseModifier.ANSI_RESET);
                    String userSearch = input.getString();
                    DatabaseModifier.searchContact(dataFilePath, userSearch);

                    System.out.println(DatabaseModifier.ANSI_YELLOW + "Would you like to search a new name? y/n" + DatabaseModifier.ANSI_RESET);
                    String confirm = input.getString();

                    if (!confirm.equalsIgnoreCase("y")) {
                        System.out.println(DatabaseModifier.ANSI_YELLOW + "\nWould you like to return to main menu? y/n" + DatabaseModifier.ANSI_RESET);

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
                    System.out.println(DatabaseModifier.ANSI_GREEN + "Enter name of contact to delete" + DatabaseModifier.ANSI_RESET);
                    String deleteUser = input.getString();

                    DatabaseModifier.deleteContact(dataFilePath, deleteUser);
                    System.out.printf(DatabaseModifier.ANSI_RED + "\n%s has been deleted from the contact list\n", deleteUser + DatabaseModifier.ANSI_RESET);

                    System.out.println(DatabaseModifier.ANSI_YELLOW + "\nWould you like to delete another user? y/n" + DatabaseModifier.ANSI_RESET);
                    String confirm = input.getString();
                    if (!confirm.equalsIgnoreCase("y")) {
                        System.out.println(DatabaseModifier.ANSI_YELLOW + "Would you like to return to main menu? Y/N" + DatabaseModifier.ANSI_RESET);

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
