import java.util.ArrayList;

public class Database {

    private ArrayList<Superhelt> superhelteArrayList = new ArrayList<>();

    // Test data
    public Database(){
        createSuperhelt("Batman", "Money", "Ja", 1965, 2);
        createSuperhelt("Superman", "Kan flyve", "Nej", 1922, 50);
        createSuperhelt("Spider-man", "Edderkoppekrafter", "Ja", 1946, 4);

    }

    public void createSuperhelt(String navn, String superkraft, String erMenneske, int introÅr, double strength) {

        Superhelt superhelt = new Superhelt(navn, superkraft, erMenneske, introÅr, strength);
        superhelteArrayList.add(superhelt);
    }

    public ArrayList<Superhelt> getSuperhelteArrayList() {
        return superhelteArrayList;
    }

    public Superhelt searchFor(String searchTerm) {
        for (Superhelt hero : superhelteArrayList) {
            if (hero.getNavn().toLowerCase().contains(searchTerm.toLowerCase())) {
                return hero;
            }
        }
        return null;
    }

}