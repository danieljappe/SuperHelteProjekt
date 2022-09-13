public class Database {

    public void createSuperhelt(String navn, String superkraft, boolean erMenneske, int introÅr, double strength) {

        Superhelte superhelt1 = new Superhelte(navn,superkraft,erMenneske,introÅr,strength);

        System.out.println(superhelt1.getNavn());

        /* Superhelte[] helteArray = new Superhelte[]{superhelt}; */

    }


}
