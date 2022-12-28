import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScanFile scanFile = new ScanFile();
        Enigma enigma = new Enigma();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the date (yyyy/mm/dd) : ");
        String date = input.next();
        System.out.print("Enter the codedMessage : ");
        String codedMessage = input.next();

        scanFile.readFile(new File("EnigmaFile.txt"), date, enigma);
        char strChars[] = codedMessage.toCharArray();
        for (char c : strChars) {
            System.out.print(enigma.enigmaDecoding(c));
        }
    }
}