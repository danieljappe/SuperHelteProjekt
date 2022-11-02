import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Controller {
    Database database = new Database();

    public void createSuperhelt(String navn, String superkraft, boolean menneske, int introÅr, double strength) {
        database.createSuperhelt(navn, superkraft, menneske, introÅr, strength);
    }

    public ArrayList<Superhelt> getSuperhelteArrayList() {
        return database.getSuperhelteArrayList();
    }

    public ArrayList<Superhelt> searchFor(String searchTerm) {
        return searchFor(searchTerm);
    }

    public void deleteSuperhero(Superhelt deleteSuperhelt) {
        database.deleteSuperhero(deleteSuperhelt);
    }

    public void saveData() throws FileNotFoundException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.saveData(getSuperhelteArrayList());
    }

    public void loadData() throws FileNotFoundException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.loadData();
    }
}
