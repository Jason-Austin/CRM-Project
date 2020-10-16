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
        String contactInfo = name + ": " + phoneNumber;
        Files.write(path, Arrays.asList(contactInfo), StandardOpenOption.APPEND);
        System.out.printf("%s(%s) added to Contacts.txt", name, phoneNumber);
    }

    //remove a line from the file


    public static void deleteContact(Path path, String nameToRemove) throws IOException{
        List<String> fileContents = Files.readAllLines(path);
        List<String> modifiedList = new ArrayList<>();
        for(String contact : fileContents){
            //I want to remove bread

            if(!contact.contains(nameToRemove)){
                modifiedList.add(contact);
            }
        }
        System.out.println(modifiedList);
        Files.write(path, modifiedList);
    }
}
