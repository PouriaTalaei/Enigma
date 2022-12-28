import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Objects;

public class ScanFile {
    public void readFile(File file, String input,Enigma enigma) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = fileReader.readLine()) != null) {
                String[] lineItems = line.split(" "); //splitting the line and adding its items in String[]
                if (Objects.equals(lineItems[0], "Date:"))
                    if (Objects.equals(lineItems[1], input)) {
                        enigma.plugBoard(fileReader.readLine());
                        enigma.rotor1(fileReader.readLine());
                        enigma.rotor2(fileReader.readLine());
                        enigma.rotor3(fileReader.readLine());
                        return;
                    }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}
