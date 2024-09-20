package opgave02;

import java.util.Random;
import java.util.Scanner;

public class Craps {

    public static void main(String[] args) {
        playCraps();
    }

    public static void playCraps() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int wins = 0;
        int losses = 0;
        boolean spiligen;

        do {
            System.out.println("Velkommen til Craps!");
            System.out.println();
            printrules();
            System.out.println();

            // Første kast ('come out roll')
            int førstekast = rollDice(rand);
            System.out.println("Første kast: " + førstekast);

            if (førstekast == 7 || førstekast == 11) {
                System.out.println("Du har vundet!");
                wins++;
            } else if (førstekast == 2 || førstekast == 3 || førstekast == 12) {
                System.out.println("Du har tabt!");
                losses++;
            } else {
                int point = førstekast;
                System.out.println("Dit point er nu: " + point);

                int nytkast;
                do {
                    System.out.println("Tryk Enter for at kaste igen...");
                    scanner.nextLine();

                    nytkast = rollDice(rand);
                    System.out.println("Du kastede: " + nytkast);

                    if (nytkast == point) {
                        System.out.println("Du har vundet ved at kaste dit point!");
                        wins++;
                        break;
                    } else if (nytkast == 7) {
                        System.out.println("Du har tabt ved at kaste 7.");
                        losses++;
                        break;
                    }

                } while (true);  // Kører i loop indtil spilleren vinder eller taber
            }

            // Spørger spilleren, om de vil spille igen
            System.out.println("Vil du spille igen? (ja/nej)");
            String response = scanner.nextLine();
            spiligen = response.equalsIgnoreCase("ja"); // Så programmet er ligeglad med om inputtet er ja, Ja, jA osv..

        } while (spiligen);

        // Udskriver antal vundne og tabte spil
        System.out.println("Spillet er slut.");
        System.out.println("Du har vundet " + wins + " spil.");
        System.out.println("Du har tabt " + losses + " spil.");

        scanner.close();
    }

    public static int rollDice(Random rand) {
        int terning1 = rand.nextInt(6) + 1;
        int terning2 = rand.nextInt(6) + 1;
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



