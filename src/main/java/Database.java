import java.util.ArrayList;

public class Database {

    // Main arraylist
    private ArrayList<Superhelt> superhelteArrayList = new ArrayList<>();

    public ArrayList<Superhelt> getSuperhelteArrayList() {
        return superhelteArrayList;
    }


    public void createSuperhelt(String navn, String superkraft, boolean erMenneske, int introÅr, double strength) {
        Superhelt superhelt = new Superhelt(navn, superkraft, erMenneske, introÅr, strength);
        superhelteArrayList.add(superhelt);
    }


    public ArrayList<Superhelt> searchFor(String searchTerm) {

        ArrayList<Superhelt> søgeResultat = new ArrayList<>();

        for (Superhelt hero : superhelteArrayList) {
            if (hero.getNavn().toLowerCase().contains(searchTerm.toLowerCase().trim())) {
                søgeResultat.add(hero);
            }
        }
        return søgeResultat;
    }


    public boolean deleteSuperhero(Superhelt superhero) {
        boolean success = superhelteArrayList.remove(superhero);
        return success;
    }

}