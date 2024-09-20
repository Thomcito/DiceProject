package opgave02;

import java.util.Scanner;

public class Craps {

    public static void main(String[] args) {
        System.out.println("Velkommen til Craps!");
        System.out.println();
        printrules();
        System.out.println();
        playCraps();

    }

    public static void playCraps() {
        Scanner scanner = new Scanner(System.in);
        int vinderRunder = 0;
        int runderTabt = 0;
        boolean spiligen;

        System.out.println("Spillet staret nu. Dit første slag er: ");
        System.out.println();

        do {


            // Første kast 'come out roll'
            int førstekast = rollDice();
            System.out.println("Første kast: " + førstekast);

            if (førstekast == 7 || førstekast == 11) {
                System.out.println("Du har vundet!");
                vinderRunder++;
            } else if (førstekast == 2 || førstekast == 3 || førstekast == 12) {
                System.out.println("Du har tabt!");
                runderTabt++;
            } else {
                int point = førstekast;
                System.out.println("Dit point er nu: " + point);

                int nytkast;
                do {
                    System.out.println("Tryk Enter for at kaste igen...");
                    scanner.nextLine();

                    nytkast = rollDice();
                    System.out.println("Du kastede: " + nytkast);

                    if (nytkast == point) {
                        System.out.println("Du har vundet ved at kaste dit point!");
                        vinderRunder++;
                        break;
                    } else if (nytkast == 7) {
                        System.out.println("Du har tabt ved at kaste 7.");
                        runderTabt++;
                        break;
                    }

                } while (true);  // Kører i loop indtil spilleren vinder eller taber
            }

            // Spørger spilleren, om de vil spille igen
            System.out.println("Vil du spille igen? (ja/nej)");
            String svar = scanner.nextLine();
            spiligen = svar.equals("ja");// Så programmet er ligeglad med om inputtet er ja, Ja, jA osv..

        } while (spiligen);

        // Udskriver antal vundne og tabte spil
        System.out.println("Spillet er slut.");
        System.out.println("Du har vundet " + vinderRunder + " spil.");
        System.out.println("Du har tabt " + runderTabt + " spil.");

        scanner.close();
    }

    private static int rollDice() {
        int terning1 = (int) (Math.random() * 6 + 1);
        int terning2 = (int) (Math.random() * 6 + 1);
        return terning1 + terning2;
    }

    public static void printrules() {
        System.out.println("Det første kast kaldes ‘come out roll’. Spilleren vinder med det samme, hvis det første kast er 7\n" +
                "eller 11, og taber med det samme, hvis det første kast er 2, 3 eller 12. Hvis spillerens første kast er\n" +
                "4, 5, 6, 8, 9 eller 10, etableres dette tal som spillerens ‘point’. Spilleren bliver derefter ved med at\n" +
                "kaste, indtil han enten kaster sit ‘point’ igen eller kaster 7. Kaster han 7, har han tabt. Kaster han\n" +
                "sit ’point’, har han vundet.");

    }

}



