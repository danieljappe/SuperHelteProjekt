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
}
