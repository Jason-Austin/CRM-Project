import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class DatabaseModifier {

    public static void addContact (Path path, String name, String phoneNumber) throws IOException {
        String contactInfo = name +": "+ phoneNumber;
        Files.write(path, Arrays.asList(contactInfo), StandardOpenOption.APPEND);
        System.out.printf("%s(%s) added to Contacts.txt", name, phoneNumber);
    }

}
