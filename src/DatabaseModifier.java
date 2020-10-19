import files.FileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseModifier {

    public static void addContact(Path path, String name, String phoneNumber) throws IOException {
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

    //remove a line from the file


    public static void deleteContact(Path path, String nameToRemove) throws IOException {
        List<String> fileContents = Files.readAllLines(path);
        List<String> modifiedList = new ArrayList<>();
        for (String contact : fileContents) {
            if (!contact.contains(nameToRemove)) {
                modifiedList.add(contact);
            }
        }
        System.out.println(modifiedList);
        Files.write(path, modifiedList);
    }

    public static void clearList(Path path) throws IOException  {
        Files.write(path, new ArrayList<>());
        System.out.println("Everyone is gone");
        FileIO.printFileContents(path);
    }

}
