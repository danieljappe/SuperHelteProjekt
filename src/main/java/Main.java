import java.util.Scanner;

public class Main {

    int valg;
    Scanner brugerInput = new Scanner(System.in);

    public void startMenu() {
        System.out.println("Velkommen til Superhelte-databasen");
        System.out.println("1: Opret din superhelt");
        System.out.println("9: Afslut program");
        int valg = brugerInput.nextInt();
        if (valg == 1) {
        opretHelt();
        } else if (valg == 9) {
            System.exit(0);
        }
    }

public void opretHelt() {

    System.out.println("Indtast et superhelte navn:");
    String navn = brugerInput.nextLine();

    System.out.println("Indtast en superkraft:");
    String superkraft = brugerInput.nextLine();

    System.out.println("Er din helt et menneske?");
    String menneske = brugerInput.nextLine();

    System.out.println("Indtast introduktionsår");
    int introÅr = brugerInput.nextInt();

    System.out.println("Indtast strength");
    double strength = brugerInput.nextDouble();


}

    public static void main(String[] args) {
        Main program= new Main();
        program.startMenu();

    }
}
