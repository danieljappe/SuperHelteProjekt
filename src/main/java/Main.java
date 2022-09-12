import java.util.Scanner;

public class Main {

    public static void Main(String[] args) {

        Scanner brugerInput = new Scanner(System.in);

        System.out.println("Velkommen til Superhelte-databasen");
        System.out.println("Opret din superhelt");
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

        Superhelte brugerSuperhelt = new Superhelte(navn,superkraft,menneske,introÅr,strength);


    }
}
