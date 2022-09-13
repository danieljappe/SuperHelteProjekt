import java.util.ArrayList;

public class Database {

    private ArrayList<Superhelte> superhelteArrayList = new ArrayList<>();

    public void createSuperhelt(String navn, String superkraft, boolean erMenneske, int introÅr, double strength) {

        Superhelte superhelt = new Superhelte(navn,superkraft,erMenneske,introÅr,strength);
        superhelteArrayList.add(superhelt);
    }

    public void seSuperhelte() {
        for (Object helt : superhelteArrayList) {
            System.out.println(helt);
        }
    }


}
