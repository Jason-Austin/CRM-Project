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

        System.out.println("Welcome to Contact List");
        System.out.println("1-View Contacts");
        System.out.println("2-Add new Contact");
        System.out.println("3-Search contact by name");
        System.out.println("4-Delete existing contact");
        System.out.println("0-Exit");


        Input input = new Input();

        System.out.println("Would you like to enter a New contct? Y/N");
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

//        DatabaseModifier.deleteContact(dataFilePath, "bill");



        //PRINT ENTIRE LIST
//        FileIO.printFileContents(dataFilePath);

        // WILL DELETE ENTIRE LIST
//        DatabaseModifier.clearList(dataFilePath);

    }


}
