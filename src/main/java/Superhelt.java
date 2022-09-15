public class Superhelt {

    private String navn;
    private String superkraft;
    private String erMenneske;
    private int introÅr;
    private double strength;

    public Superhelt(String navn, String superkraft, String erMenneske, int introÅr, double strength) {
        this.navn = navn;
        this.superkraft = superkraft;
        this.erMenneske = erMenneske;
        this.introÅr = introÅr;
        this.strength = strength;
    }

    public String getNavn(){
        return navn;
    }
        public void setNavn(){
            this.navn = navn;
        }

    public String getSuperkraft(){
        return superkraft;
    }
        public void setSuperkraft(String superkraft) {
            this.superkraft = superkraft;
        }

    public String getMenneske(){
        return erMenneske;
    }
        public void setErMenneske(String erMenneske) {
            this.erMenneske = erMenneske;
        }

    public int getIntroÅr(){
        return introÅr;
    }
        public void setIntroÅr(int introÅr) {
            this.introÅr = introÅr;
        }

    public double getStrength(){
        return strength;
    }
        public void setStrength(){
            this.strength = strength;
        }

    @Override
    public String toString() {
        return "------------------------\nNavn: " + navn + "\nSuperkraft: " + superkraft + "\nEr menneske: " +
                erMenneske + "\nIntroduktionsår: " + introÅr + "\nStrength: " + strength + "\n------------------------";
    }

}
