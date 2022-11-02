import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    public void saveData(ArrayList<Superhelt> superheltArrayList) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("data/superheroes.csv"));

        for (Superhelt superhelt : superheltArrayList){
            output.print(superhelt.getNavn());
            output.print(";");
            output.print(superhelt.getSuperkraft());
            output.print(";");
            output.print(superhelt.getMenneske());
            output.print(";");
            output.print(superhelt.getIntroÅr());
            output.print(";");
            output.print(superhelt.getStrength());
            output.print(";");
            output.println();
        }
    }

    public void loadData() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("data/superheroes.csv"));
        while (scanner.hasNextLine()){

        }
    }
}
