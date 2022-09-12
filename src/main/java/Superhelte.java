public class Superhelte {

    private String navn;
    private String superkraft;
    private String menneske; // boolean?
    private int introÅr;
    private double strength;

    public Superhelte(String navn, String superkraft, String menneske, int introÅr, double strength) {
        this.navn = navn;
        this.superkraft = superkraft;
        this.menneske = menneske;
        this.introÅr = introÅr;
        this.strength = strength;

    }

    public Superhelte() {
        Superhelte brugerSuperhelt = new Superhelte(navn,superkraft,menneske,introÅr,strength);
    }


    public String getNavn(){
        return navn;
    }
    public String getSuperkraft(){
        return superkraft;
    }
    public String getMenneske(){
        return menneske;
    }
    public int getIntroÅr(){
        return introÅr;
    }
    public double getStrength(){
        return strength;
    }


}
