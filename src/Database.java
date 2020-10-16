import files.FileIO;


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
//        ArrayList<String> contactList = new ArrayList<>();
        List<String> contactList = Arrays.asList();
        DatabaseModifier.addContact(dataFilePath, "Austin", "8303914229");


    }
}
