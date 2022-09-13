public class Superhelte {

    private String navn;
    private String superkraft;
    private String erMenneske;
    private int introÅr;
    private double strength;

    public Superhelte(String navn, String superkraft, String erMenneske, int introÅr, double strength) {
        this.navn = navn;
        this.superkraft = superkraft;
        this.erMenneske = erMenneske;
        this.introÅr = introÅr;
        this.strength = strength;
    }

    public String getNavn(){
        return navn;
    }
    public String getSuperkraft(){
        return superkraft;
    }
    public String getMenneske(){
        return erMenneske;
    }
    public int getIntroÅr(){
        return introÅr;
    }
    public double getStrength(){
        return strength;
    }


}
