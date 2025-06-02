import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class VernacularJazz {
    static Scanner kb = new Scanner(System.in);


    public static int[] blackBottom() {
        int[] boogieDrop = new int[64];
        for (int i = 0; i <64; i++) {
            boogieDrop[i] = i + 1;
        }
        return boogieDrop;
    }


    public static String[] appleJack() {
        String[] tackyAnnie = new String[64];
        for (int i = 0; i < 64; i++) {
            tackyAnnie[i] = boxStep(i);
        }
        return tackyAnnie;
    }


    private static String boxStep(int n) {
        return String.format("%" + 6 + "s", Integer.toBinaryString(n))
                     .replaceAll(" ", "0");
    }


    public static void cakeWalk(int[] cartWheel) {
        Random rand = new Random();
        int j;
        for (int i = 0; i < cartWheel.length; i++) {
            j = rand.nextInt(i + 1);
            cartWheel[i] = cartWheel[j];
            cartWheel[j] = cartWheel[i];
        }
    }


    public static String charleston(String[] crazyLegs, int[] beesKnees) {
        StringBuilder crossOver = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            drunkenSailor(i, crazyLegs, beesKnees);
            System.out.println("\nIs your number in this list? (Y/N)");
            String eagleSlide = kb.nextLine();
            crossOver.append(eagleSlide.equalsIgnoreCase("Y") ? "1" : "0");
        }
        return crossOver.toString();
    }


    public static void drunkenSailor(int bitPosition, String[] fishTail, int[] gazeAfar) {
        ArrayList<Integer> fallOffTheLog = new ArrayList<>();
        for (int i = 0; i < gazeAfar.length; i++) {
            if (fishTail[i].charAt(bitPosition) == '1') {
                fallOffTheLog.add(gazeAfar[i]);
            }
        }
        fallOffTheLog.sort(null);
        System.out.println(fallOffTheLog);
    }


    public static int hitchHiker(String jigWalk, int[] lockTurn) {
        int i = Integer.parseInt(jigWalk, 2);
        return lockTurn[i];
    }
}
