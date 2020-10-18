import files.FileIO;
import util.Input;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {


    public static void main(String[] args) throws IOException {
        String directoryName = "Contacts";
        String fileName = "Contacts.txt";

        Path dataFilePath = FileIO.createDirectoryAndFile(directoryName, fileName);

        Input input = new Input();

        System.out.println("Welcome to Contact List");
        System.out.println("1-View Contacts");
        System.out.println("2-Add new Contact");
        System.out.println("3-Search contact by name");
        System.out.println("4-Delete existing contact");
        System.out.println("0-Exit");

        //VIEW ALL CONTACTS
        System.out.println("Would you like to view all contacts? Y/N");
        String userConfirm = input.getString();

        if (userConfirm.equalsIgnoreCase("y")) {

            FileIO.printFileContents(dataFilePath);
        }

//         ADD NEW CONTACT
        System.out.println("Would you like to enter a New contact? Y/N");
        String userInput = input.getString();

        if (userInput.equalsIgnoreCase("y")) {
            System.out.println("please enter Name");
            String name = input.getString();

            System.out.println("Please enter Phone Number");
            String phoneNumber = input.getString();

            DatabaseModifier.addContact(dataFilePath, name, phoneNumber);
            FileIO.printFileContents(dataFilePath);
        } else {
            FileIO.printFileContents(dataFilePath);
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
