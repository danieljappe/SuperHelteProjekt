import java.util.Scanner;

public class UserInterface {
    Database database = new Database();
    int valg;
    Scanner scan = new Scanner(System.in);

    public void startMenu() {
        do {
            System.out.println("\nVelkommen til Superhelte-databasen\n");
            System.out.println("1: Opret din superhelt");
            System.out.println("2: Se listen over helte");
            System.out.println("3: Find en helt i databsen");
            System.out.println("4: Rediger en helt i databasen");
            System.out.println("9: Afslut program");
            int valg = scan.nextInt();
            scan.nextLine(); // Fix for scanner bug
            if (valg == 1) {
                opretHelt();
            } else if (valg == 2) {
                seHelte();
            } else if (valg == 3) {
                søgPåHelt();
            } else if (valg == 4) {
                redigerHelt();
            } else if (valg == 9) {
                System.out.println("Lukker program...");
                System.exit(0);
            }
        } while (valg != 9);
    }

    public void opretHelt() {
        System.out.println("Her kan du oprette din helt.");
        System.out.print("Indtast et superhelte navn: ");
        String navn = scan.nextLine();

        System.out.print("Indtast en superkraft: ");
        String superkraft = scan.nextLine();

        System.out.print("Er din helt et menneske? ");
        String menneske = scan.nextLine();


        System.out.print("Indtast introduktionsår: ");
        int introÅr = scan.nextInt();

        System.out.print("Indtast strength (Et menneske svarer til 1.0): ");
        double strength = scan.nextDouble();

        database.createSuperhelt(navn, superkraft, menneske, introÅr, strength);
    }

    public void seHelte() {
        System.out.println("Her kan du se listen over gemte helte: ");
        for (Superhelt helt : database.getSuperhelteArrayList())
            System.out.println("------------------------\nNavn: " + helt.getNavn() + "\nSuperkraft: " + helt.getSuperkraft() + "\nEr menneske: " + helt.getMenneske() +
                    "\nIntroduktionsår: " + helt.getIntroÅr() + "\nStrength: " + helt.getStrength() + "\n");

    }

    public void søgPåHelt() {
        System.out.println("Søg på din helt: ");
        String searchTerm = scan.nextLine();
        Superhelt superhelt = database.searchFor(searchTerm);
    }

    public void redigerHelt() {
        for (int i = 0; i < database.getSuperhelteArrayList().size(); i++) {
            System.out.println(i + 1 + ":" + database.getSuperhelteArrayList().get(i));
        }

        System.out.println("Indtast nummer på den helt der skal redigeres: ");
        int nr = scan.nextInt();
        scan.nextLine(); // scannerbug

        Superhelt editSuperhelt = database.getSuperhelteArrayList().get(nr - 1); // index starter fra 0
        System.out.println("Rediger helt: " + editSuperhelt);

        System.out.println("Rediger data og tryk enter / Hvis data ikke skal ændres tryk ENTER");
        System.out.println("Navn: " + editSuperhelt.getNavn());
        String nytNavn = scan.nextLine();
        if (!nytNavn.isEmpty())
            editSuperhelt.setNavn(nytNavn);

        System.out.println("Superkraft: " + editSuperhelt.getSuperkraft());
        String nySuperkraft = scan.nextLine();
        if (!nySuperkraft.isEmpty())
            editSuperhelt.setSuperkraft(nySuperkraft);

        System.out.println("Er menneske: " + editSuperhelt.getMenneske());
        String nyErMenneske = scan.nextLine();
        if (!nyErMenneske.isEmpty())
            editSuperhelt.setErMenneske(nyErMenneske);

        System.out.println("Introduktionsår: " + editSuperhelt.getIntroÅr());
        String nyIntroÅr = scan.nextLine();
        if (!nyIntroÅr.isEmpty())
            editSuperhelt.setIntroÅr(Integer.parseInt(nyIntroÅr));

        System.out.println("Strength: " + editSuperhelt.getStrength());
        String nyStrength = scan.nextLine();
        if (!nyStrength.isEmpty())
            editSuperhelt.setStrength(Double.parseDouble(nyStrength));

    }

}


