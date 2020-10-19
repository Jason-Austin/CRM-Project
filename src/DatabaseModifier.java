import files.FileIO;
import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DatabaseModifier {

    public static void addContact(Path path, String name, String phoneNumber) throws IOException {
        List<String> fileContents = Files.readAllLines(path);

        if (fileContents.contains(name)){

            System.out.printf("%s already exists, would you like to override it? y/n", name);
            Scanner scanner = new Scanner(System.in);

            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("y")){
                updateLine(path, name, name);
            }
        }

        String contactInfo = String.format("%-15s" ,name) + String.format("| %-12s |" ,phoneNumber);
        Files.write(path, Arrays.asList(contactInfo), StandardOpenOption.APPEND);
        System.out.printf("%-10s| %-10s added to Contacts.txt\n", name, phoneNumber);
    }

    //TODO: add Search by NAme function. PREVENT search from deleting existin names
    public static void searchContact(Path path, String nameToSearch) throws IOException {
        System.out.println("Enter new name, and phoneNumber");
        List<String> fileContents = Files.readAllLines(path);
        List<String> modifiedList = new ArrayList<>();
        for (String contact : fileContents) {
            //I want to remove bread

            if (contact.contains(nameToSearch)) {
                modifiedList.add(contact);
            }
        }
        System.out.println(modifiedList);
    }

//    public static searchContact(Path path, String nameToSearch) throws IOException {
//
//        List<String> fileContents = Files.readAllLines(path);
//        List<String> modifiedList = new ArrayList<>();
//        for (String contact : fileContents) {
//
//            if (contact.contains(nameToSearch)) {
//                modifiedList.add(contact);
//                return modifiedList;
//            }
//        }
//
//    }

    //remove a line from the file


    public static void deleteContact(Path path, String nameToRemove) throws IOException {
        List<String> fileContents = Files.readAllLines(path);
        List<String> modifiedList = new ArrayList<>();
        for (String contact : fileContents) {
            if (!contact.contains(nameToRemove)) {
                modifiedList.add(contact);
            }
        }
        Files.write(path, modifiedList);
    }

    public static void clearList(Path path) throws IOException  {
        Files.write(path, new ArrayList<>());
        System.out.println("Everyone is gone");
        FileIO.printFileContents(path);
    }

    public static void updateLine(Path filePath, String oldValue, String newValue) throws IOException{
        //Replace a line on the file.
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();
        for(String item : fileContents){
            if (item.equalsIgnoreCase(oldValue)) {
                // Add my modified item.
                modifiedList.add(newValue);
            }else {
                // Add the existing item because it is not what we want to replace.
                modifiedList.add(item);
            }
        }
        Files.write(filePath, modifiedList);
    }

}
