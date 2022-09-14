import java.util.Scanner;

public class Main {

    Database database = new Database();

    int valg;
    Scanner brugerInput = new Scanner(System.in);

    public void startMenu() {
       do {
           System.out.println("\nVelkommen til Superhelte-databasen\n");
           System.out.println("1: Opret din superhelt");
           System.out.println("2. Se listen over helte");
           System.out.println("9: Afslut program");
           int valg = brugerInput.nextInt();
           brugerInput.nextLine(); // Fix for scanner bug
           if (valg == 1) {
               opretHelt();
           } else if (valg == 2) {
               seHelte();
           } else if (valg == 9) {
               System.out.println("Lukker program...");
               System.exit(0);
           }
       }while (valg != 9);
    }

    public void opretHelt() {
        System.out.println("Her kan du oprette din helt.");
        System.out.print("Indtast et superhelte navn: ");
        String navn = brugerInput.nextLine();

        System.out.print("Indtast en superkraft: ");
        String superkraft = brugerInput.nextLine();

        System.out.print("Er din helt et menneske? ");
        String menneske = brugerInput.nextLine();

        System.out.print("Indtast introduktionsår: ");
        int introÅr = brugerInput.nextInt();

        System.out.print("Indtast strength (Et menneske svarer til 1.0): ");
        double strength = brugerInput.nextDouble();

        database.createSuperhelt(navn,superkraft,menneske,introÅr,strength);
    }

    public void seHelte() {
        System.out.println("Her kan du se listen over gemte helte:\n" +
                            "-------------------------------------");
        for (Superhelte helt : database.getSuperhelteArrayList())
            System.out.println("Navn: " + helt.getNavn() + "\nSuperkraft: " + helt.getSuperkraft() + "\nEr menneske: " + helt.getMenneske() +
                                                "\nIntroduktionsår: " + helt.getIntroÅr() + "\nStrength: " + helt.getStrength() + "\n");

    }

    public static void main(String[] args) {
        Main program = new Main();
        program.startMenu();

    }
}
