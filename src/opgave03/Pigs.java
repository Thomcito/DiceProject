package opgave03;

import java.util.Scanner;

public class Pigs {
    private static int rollCount = 0;
    private static int roundCount = 0;


    public static void main(String[] args) {
        System.out.println("Velkommen til spillet Pig AKA 100!");
        printRules();
        System.out.println();

        playPig();

        System.out.println();
        System.out.println("Tak for at spille Pig");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Spillets gang");
        System.out.println("Første spiller kaster en terning, indtil han enten kaster 1, eller beslutter sig for at stoppe. Hvis han\n" +
                "slår en 1’er, får han ingen point i denne runde. Hvis han beslutter sig for at stoppe, inden har slår\n" +
                "en 1’er, lægges summen af alle hans kast i denne runde sammen med hans samlede antal point,\n" +
                "og turen går videre til næste spiller. Derefter skiftes spillerne til at kaste. Den første spiller, der\n" +
                "samlet når 100 point, har vundet.");
        System.out.println("=====================================================");
    }

    public static void playPig() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Klar til at starte spillet? ('ja/nej') ");
        String answer = scanner.nextLine();
        if (answer.equals("nej")) {
            System.out.println("Du vil ikke spille, spillet er slut");
        }
        System.out.println("Hvad vil i spille til?");
        int spilLængde = scanner.nextInt();

        int spiller1Point = 0;
        int spiller2Point = 0;
        int nuværendeSpiller = 1;
        boolean spilVundet = false;

        while (!answer.equals("nej") && spilVundet != true) {
            int rundePoint = 0;
            boolean fortsætSpil = true;

            System.out.println("--------------------------------------------------------");
            System.out.println("\nDet er nu " + "spiller " + nuværendeSpiller + "s tur");

            System.out.println("Du prøver lykken! Tryk Enter: ");
            String svar = scanner.nextLine();
            System.out.println();

            while (fortsætSpil == true) {
                int rulTerning = rollDie();

                System.out.println("Du rullede " + rulTerning);
                updateRoll();

                if (rulTerning == 2) {
                    rundePoint = -1;
                    fortsætSpil = false;
                } else if (rulTerning == 1) {
                    System.out.println("Du ramte desværre " + rulTerning + ", du mister derfor denne rundes point");
                    rundePoint = 0;
                    fortsætSpil = false;
                } else {
                    rundePoint += rulTerning;
                    System.out.println("Din nuværende point for runden er: " + rundePoint);
                    System.out.println("Tør du tage et kast mere? ('ja/nej') ");
                    svar = scanner.nextLine();

                    if (svar.equals("nej")) {
                        fortsætSpil = false;
                    }
                }
            }

            if (nuværendeSpiller == 1) {

                if (rundePoint == -1) {
                    spiller1Point = 0;
                } else {
                    spiller1Point += rundePoint;
                }
                System.out.println("Spiller 1's nuværende point er: " + spiller1Point);
                roundCount++;
                if (spiller1Point >= spilLængde) {
                    spilVundet = true;
                    System.out.println("Spiller 1 vandt!");
                } else {
                    nuværendeSpiller = 2;
                }

            } else if (nuværendeSpiller == 2) {
                if (rundePoint == -1) {
                    spiller2Point = 0;
                } else {
                    spiller2Point += rundePoint;
                }
                System.out.println("Spiller 2's nuværende point er: " + spiller2Point);
                roundCount++;
                if (spiller2Point >= spilLængde) {
                    spilVundet = true;
                    System.out.println("Spiller 2 vandt!");
                } else {
                    nuværendeSpiller = 1;
                }
            }
        }
        printStatistics();
        scanner.close();
    }

    private static int rollDie() {
        int terning1 = (int) (Math.random() * 6 + 1);
        int terning2 = (int) (Math.random() * 6 + 1);

        if (terning1 == 1 || terning2 == 1) return 1;

        return terning1 + terning2;
    }


    private static void updateRoll() {
        rollCount++;
    }

    private static void updateCount() {
        roundCount++;
    }

    private static void printStatistics() {
        System.out.println("\n---------------------------------------------------------------------");
        System.out.println("Spillerne har i alt slået: " + rollCount + " gange");
        System.out.println("Der har i alt været: " + roundCount + " runder");
        System.out.println("Det er i gennemsnit: " + (rollCount / roundCount) + " slag pr. rundte");

    }

}
