import java.util.Scanner;

public class Main {

    Database database = new Database();
    int valg;
    Scanner brugerInput = new Scanner(System.in);

    public void startMenu() {
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
            System.exit(0);
        }
    }

    public void opretHelt() {
        System.out.println("Her kan du oprette din helt.");
        System.out.print("Indtast et superhelte navn: ");
        String navn = brugerInput.nextLine();

        System.out.print("Indtast en superkraft: ");
        String superkraft = brugerInput.nextLine();

        System.out.print("Er din helt et menneske? true / false ");
        boolean menneske = brugerInput.nextBoolean();

        System.out.print("Indtast introduktionsår ");
        int introÅr = brugerInput.nextInt();

        System.out.print("Indtast strength ");
        double strength = brugerInput.nextDouble();

        database.createSuperhelt(navn,superkraft,menneske,introÅr,strength);
        startMenu();
    }

    public void seHelte() {
        System.out.println("Her kan du se listen over gemte helte:\n" +
                            "-------------------------------------");
        for (Object helt : database.getSuperhelteArrayList())
            System.out.println(helt);

        startMenu();
    }

    public static void main(String[] args) {
        Main program = new Main();
        program.startMenu();

    }
}
