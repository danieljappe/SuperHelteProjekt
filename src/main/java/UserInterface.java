import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    Controller controller = new Controller();
    Scanner scan = new Scanner(System.in);

    public void startMenu() throws FileNotFoundException {
        int valg = 0;
        boolean fejl = false;
        System.out.println("----------------------------------\n" +
                "Velkommen til Superhelte-databasen");
        do {
            System.out.println("----------------------------------");
            System.out.println("1: Opret din superhelt");
            System.out.println("2: Se listen over helte");
            System.out.println("3: Find en helt i databsen");
            System.out.println("4: Rediger en helt i databasen");
            System.out.println("5: Fjern en helt fra databasen");
            System.out.println("6: Load helte");
            System.out.println("7: Save helte");
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
                } else if (valg == 6) {
                    controller.loadData();
                } else if (valg == 7) {
                    controller.saveData();
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
        System.out.print("Er din helt et menneske? \"j/n\": ");
        boolean opretMenneskeFejl = false;
        boolean menneske = false;
        String svar;
        do {
            svar = scan.nextLine().trim().toLowerCase();
            if (svar.equals("j")) {
                menneske = true;
                break;
            } else if (svar.equals("n")) {
                menneske = false;
                break;
            } else {
                System.out.println("Tast venligst \"j\" eller \"n\"");
                opretMenneskeFejl = true;
            }
        } while (opretMenneskeFejl = true);

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
            System.out.print("Indtast strength: ");
            try {
                strength = scan.nextDouble();
                fejl = false;
            } catch (InputMismatchException e) {
                System.out.println("Der skete en fejl, prøv igen");
                scan.nextLine(); // Fix for scanner bug
                fejl = true;
            }
        } while (fejl == true);


        // Slut
        controller.createSuperhelt(navn, superkraft, menneske, introÅr, strength);
    }

    public void seHelte() {
        System.out.println("Her kan du se listen over gemte helte: ");
        for (Superhelt helt : controller.getSuperhelteArrayList())
            System.out.println("------------------------\nNavn: " + helt.getNavn() + "\nSuperkraft: " +
                    helt.getSuperkraft() + "\nEr menneske: " + helt.getMenneske() + "\nIntroduktionsår: " +
                    helt.getIntroÅr() + "\nStrength: " + helt.getStrength() + "\n");

    }

    public void søgPåHelt() {
        System.out.println("Søg på din helt: ");
        String searchTerm = scan.nextLine();

        ArrayList<Superhelt> søgeResultat = controller.searchFor(searchTerm);

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
        boolean redigerHeltFejl = false;

        for (int i = 0; i < controller.getSuperhelteArrayList().size(); i++) {
            System.out.println(i + 1 + ":" + controller.getSuperhelteArrayList().get(i));
        }
        System.out.println("Indtast nummer på den helt der skal redigeres: ");
        int nr = scan.nextInt();
        scan.nextLine(); // scannerbug

        Superhelt editSuperhelt = controller.getSuperhelteArrayList().get(nr - 1); // index starter fra 0


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
        System.out.println("Er menneske: " + editSuperhelt.getMenneske() + "Indtast j/n");
        String nyErMenneske = scan.nextLine();
        if (!nyErMenneske.isEmpty())
            editSuperhelt.setErMenneske(Boolean.parseBoolean(nyErMenneske));

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
        boolean deleteHeltFejl = false;

        for (int i = 0; i < controller.getSuperhelteArrayList().size(); i++) {
            System.out.println(i + 1 + ":" + controller.getSuperhelteArrayList().get(i));
        }
        System.out.println("Indtast nummer på den helt der skal slettes: ");

        do {
            int nr = scan.nextInt();
            String sletHelt = scan.nextLine(); // scannerbug
            if (!sletHelt.isEmpty())
                try {
                    Superhelt deleteSuperhelt = controller.getSuperhelteArrayList().get(nr - 1); // index starter fra 0
                    System.out.println("Helt slettet");
                    controller.deleteSuperhero(deleteSuperhelt);
                } catch (Exception e) {
                    System.out.println("Der skete en fejl, indtast venligst et nummer fra listen");
                    deleteHeltFejl = true;
                }
        } while (deleteHeltFejl == true);
    }
}


