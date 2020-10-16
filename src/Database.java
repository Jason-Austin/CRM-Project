import files.FileIO;

import java.io.IOException;
import java.nio.file.Path;

public class Database {
    public static void main(String[] args) throws IOException {
        String directoryName = "Contacts";
        String fileName = "Contacts.txt";

        try {
            Path dataFilePath = FileIO.createDirectoryAndFile(directoryName, fileName);


        } catch (IOException ex) {
            System.out.println("Cannot Create the file");
            ex.printStackTrace();
        }
    }
}
