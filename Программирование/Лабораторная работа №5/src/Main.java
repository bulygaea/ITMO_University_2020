import java.io.File;
import java.io.FileNotFoundException;  // Эксепшн из-за считывания данных из файла
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("data.csv");
        Scanner scanner = new Scanner(input);

        ArrayList<String[]> collection = new ArrayList<>();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] lineArray = line.split(", ");

        }

        // System.out.println(lineArray);
    }
}
