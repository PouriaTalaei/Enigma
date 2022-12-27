import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Objects;

public class ScanFile {


    public static void readFile(File test2,String input) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(test2))) {
            String line = "";
            while ((line = fileReader.readLine()) != null) {
                String[] lineItems = line.split(" "); //splitting the line and adding its items in String[]
                if (Objects.equals(lineItems[0], "Date:"))
                    if(Objects.equals(lineItems[1], input)){

                    }


            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        // return Data;

    }
}
