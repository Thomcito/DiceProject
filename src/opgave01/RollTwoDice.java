package opgave01;

import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;
    private static int sum = 0;
    private static int sammeAntalØjne = 0;
    private static int størsteØjne = 0;
    private static int[] antaløjne = {1, 2, 3, 4, 5, 6};
    private static int[] resultatAfØjne = new int[6];


    public static void main(String[] args) {
        System.out.println("Velkommen til spillet, rul to terninger.");
        printRules();
        System.out.println();

        playDice();

        System.out.println();
        System.out.println("Tak for at spille, rul to terninger.");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for rul to terninger");
        System.out.println("Spilleren ruller to terninger, så længe man lyster.");
        System.out.println("=====================================================");
    }

    public static void playDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul to terninger? ('ja/nej') ");
        String answer = scanner.nextLine();
        while (!answer.equals("nej")) {
            int[] faces = rollDice();
            System.out.println("Du rullede: " + faces[0]);
            System.out.println("Du rullede: " + faces[1]);
            sum += faces[0] + faces[1];

            if (faces[0] == faces[1]) {
                sammeAntalØjne++;
            }
            if (faces[0] + faces[1] > størsteØjne) {
                størsteØjne = faces[0] + faces[1];
            }
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < antaløjne.length; j++) {
                    if (faces[i] == antaløjne[j]) {
                        resultatAfØjne[j]++;
                    }
                }
            }
            updateStatistics();

            System.out.print("Rul to terninger? ('ja/nej') ");
            answer = scanner.nextLine();

        }

        printStatistics();
        scanner.close();

    }

    private static int[] rollDice() {
        int[] dices = new int[2];
        dices[0] = (int) (Math.random() * 6 + 1);
        dices[1] = (int) (Math.random() * 6 + 1);
        return dices;
    }


    private static void updateStatistics() {
        rollCount++;
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Antal rul:", rollCount);
        System.out.println("Den totale sum af alle terningekastene er: " + sum);
        System.out.println("Du har slået de samme antal øjne " + sammeAntalØjne + " Gange");
        System.out.println("Det største antal øjne du har slået er: " + størsteØjne);
        for (int i = 0; i < resultatAfØjne.length; i++) {
            System.out.println("antal " + antaløjne[i] + "ere = " + resultatAfØjne[i]);

        }

    }

}


