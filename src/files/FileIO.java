package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public static Path createDirectoryAndFile(String directoryName, String fileName) throws IOException{
        Path directoryPath = Paths.get(directoryName);
        Path dataFilePath = Paths.get(directoryName, fileName);

        //createFile makes an exception, added "throws" in Main. OR could wrap in try/catch.
        //have to create a directory first before we create a file.

        if (Files.notExists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }
        //OR
        if (!Files.exists(dataFilePath)) {
            Files.createFile(dataFilePath);
        }

        return dataFilePath;
    }
    public static void printFileContents(Path filePath) throws IOException{
        List<String> fileContents = Files.readAllLines(filePath);
        for (int i = 0; i < fileContents.size(); i++) {
            System.out.printf("%d: %s\n", i + 1, fileContents.get(i));
        }
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

    public static void deleteLine(Path filePath, String lineToRemove) throws IOException{
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();
        for(String item : fileContents){
            //I want to remove bread
            if(!item.equalsIgnoreCase(lineToRemove)){
                modifiedList.add(item);
            }
        }
        Files.write(filePath, modifiedList);
    }
}
