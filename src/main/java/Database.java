public class Database {

    private Superhelte superhelte = new Superhelte();

    public void Superhelte() {
        Superhelte helt1 = new Superhelte(superhelte.getNavn(), superhelte.getSuperkraft(),
                superhelte.getMenneske(), superhelte.getIntroÅr(), superhelte.getStrength());

        /*Superhelte helt2 = new Superhelte(superhelte.getNavn(), superhelte.getSuperkraft(),
                superhelte.getMenneske(), superhelte.getIntroÅr(), superhelte.getStrength());

        Superhelte helt3 = new Superhelte(superhelte.getNavn(), superhelte.getSuperkraft(),
                superhelte.getMenneske(), superhelte.getIntroÅr(), superhelte.getStrength());

        Superhelte helt4 = new Superhelte(superhelte.getNavn(), superhelte.getSuperkraft(),
                superhelte.getMenneske(), superhelte.getIntroÅr(), superhelte.getStrength());

        Superhelte helt5 = new Superhelte(superhelte.getNavn(), superhelte.getSuperkraft(),
                superhelte.getMenneske(), superhelte.getIntroÅr(), superhelte.getStrength());*/

        Superhelte[] helteArray = new Superhelte[]{helt1};

    }

}
