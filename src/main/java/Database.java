public class Database {

    private Superhelte superhelte = new Superhelte();

    public void createSuperhelt(String navn, String superkraft, boolean menneske, int introÅr, double strength) {

        Superhelte superhelt = new Superhelte(navn,superkraft,menneske,introÅr,strength);

        Superhelte[] helteArray = new Superhelte[]{superhelt};

    }


}
