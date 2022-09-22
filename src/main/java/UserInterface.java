import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    Database database = new Database();
    Scanner scan = new Scanner(System.in);

    public void startMenu() {
        int valg = 0;
        boolean fejl = false;
        System.out.println("----------------------------------\n" +
                            "Velkommen til Superhelte-databasen" +
                            "\n----------------------------------");
        do {
            System.out.println("1: Opret din superhelt");
            System.out.println("2: Se listen over helte");
            System.out.println("3: Find en helt i databsen");
            System.out.println("4: Rediger en helt i databasen");
            System.out.println("5: Fjern en helt fra databasen");
            System.out.println("9: Afslut program");
            try {
                valg = scan.nextInt();
                scan.nextLine(); // Fix for scanner bug

                if (valg == 1) {
                    opretHelt();
                } else if (valg == 2) {
                    seHelte();
                } else if (valg == 3) {
                    søgPåHelt();
                } else if (valg == 4) {
                    redigerHelt();
                } else if (valg == 5) {
                    deleteHelt();
                } else if (valg == 9) {
                    System.out.println("Lukker program...");
                    System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Ugyldigt input, prøv igen");
                scan.nextLine(); // Fix for scanner bug
                fejl = true;
            }
        } while (valg != 9 || fejl == true);
    }

    public void opretHelt() {
        System.out.println("Her kan du oprette din helt.");

        // Opret navn
        System.out.print("Indtast et superhelte navn: ");
        String navn = scan.nextLine();

        // Opret superkraft
        System.out.print("Indtast en superkraft: ");
        String superkraft = scan.nextLine();

        // Opret menneske
        System.out.print("Er din helt et menneske? ");
        String menneske = scan.nextLine();

        // Opret IntroÅr
        int introÅr = 0;
        boolean fejl = false;
        do {
            fejl = false;
            System.out.print("Indtast introduktionsår: ");
            try {
                introÅr = scan.nextInt();
                fejl = false;
            } catch (InputMismatchException e) {
                System.out.println("Der skete en fejl, prøv igen");
                scan.nextLine(); // Fix for scanner bug
                fejl = true;
            }
        } while (fejl == true);

        // Opret strength
        double strength = 0;
        do {
            System.out.println("Indtast strength: ");
            try {
                strength = scan.nextDouble();
                fejl = false;
            }
            catch (InputMismatchException e){
                System.out.println("Der skete en fejl, prøv igen");
                scan.nextLine(); // Fix for scanner bug
                fejl = true;
            }
        } while (fejl == true);

        System.out.print("Indtast strength (Et menneske svarer til 1.0): ");



        // Slut
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

        ArrayList<Superhelt> søgeResultat = database.searchFor(searchTerm);

        if (søgeResultat.isEmpty()) {
            System.out.println("Ingen helte fundet ift søgekriterierne");
        } else {
            System.out.println("Succes");
            for (Superhelt superhelt : søgeResultat) {
                System.out.println("------------------------\nNavn: " + superhelt.getNavn() +
                        "\nSuperkraft: " + superhelt.getSuperkraft() + "\nEr menneske: " + superhelt.getMenneske() +
                        "\nIntroduktionsår: " + superhelt.getIntroÅr() + "\nStrength: " + superhelt.getStrength() + "\n");
            }
        }
    }

    public void redigerHelt() {
        boolean fejl = false;

        for (int i = 0; i < database.getSuperhelteArrayList().size(); i++) {
            System.out.println(i + 1 + ":" + database.getSuperhelteArrayList().get(i));
        }

        System.out.println("Indtast nummer på den helt der skal redigeres: ");
        int nr = scan.nextInt();
        scan.nextLine(); // scannerbug

        Superhelt editSuperhelt = database.getSuperhelteArrayList().get(nr - 1); // index starter fra 0


        System.out.println("Rediger helt: " + editSuperhelt);
        System.out.println("Rediger data og tryk enter / Hvis data ikke skal ændres tryk ENTER");

        // Edit navn
        System.out.println("Navn: " + editSuperhelt.getNavn());
        String nytNavn = scan.nextLine();
        if (!nytNavn.isEmpty())
            editSuperhelt.setNavn(nytNavn);

        // Edit superkraft
        System.out.println("Superkraft: " + editSuperhelt.getSuperkraft());
        String nySuperkraft = scan.nextLine();
        if (!nySuperkraft.isEmpty())
            editSuperhelt.setSuperkraft(nySuperkraft);

        // Edit menneske
        System.out.println("Er menneske: " + editSuperhelt.getMenneske());
        String nyErMenneske = scan.nextLine();
        if (!nyErMenneske.isEmpty())
            editSuperhelt.setErMenneske(nyErMenneske);

        // Edit IntroÅr
        System.out.println("Introduktionsår: " + editSuperhelt.getIntroÅr());
        do {
            String nyIntroÅr = scan.nextLine().trim();
            if (!nyIntroÅr.isEmpty()) {
                try {
                    editSuperhelt.setIntroÅr(Integer.parseInt(nyIntroÅr));
                    fejl = false;
                } catch (NumberFormatException e) {
                    System.out.println("Der skete en fejl, prøv igen");
                    fejl = true;
                }
            }
        } while (fejl == true);

        // Edit Strength
        do {
            System.out.println("Strength: " + editSuperhelt.getStrength());
            String nyStrength = scan.nextLine().trim();
            if (!nyStrength.isEmpty()) {
                try {
                    editSuperhelt.setStrength(Double.parseDouble(nyStrength));
                    fejl = false;
                } catch (NumberFormatException e) {
                    System.out.println("Der skete en fejl, prøv igen");
                    fejl = true;
                }
            }
        } while (fejl == true);
    }

    public void deleteHelt() {
        for (int i = 0; i < database.getSuperhelteArrayList().size(); i++) {
            System.out.println(i + 1 + ":" + database.getSuperhelteArrayList().get(i));
        }

        System.out.println("Indtast nummer på den helt der skal slettes: ");
        int nr = scan.nextInt();
        scan.nextLine(); // scannerbug

        Superhelt deleteSuperhelt = database.getSuperhelteArrayList().get(nr - 1); // index starter fra 0

        System.out.println("Slet en helt: " + deleteSuperhelt);
        database.deleteSuperhero(deleteSuperhelt);
    }
}


