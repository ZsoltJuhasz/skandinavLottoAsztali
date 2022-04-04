import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class Reader {

    public Reader() {

    }

    public Vector<String> readFile() {
        Vector<String> numbers = new Vector<>();

        try {
            FileReader fReader = new FileReader("szamok.txt");
            Scanner sc = new Scanner(fReader);

            while (sc.hasNext()) {
                String row = sc.nextLine();
                if (row.matches("[0-9:]+")) {
                    numbers.add(row);
                }
            }
            sc.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        return numbers;
    }
}
