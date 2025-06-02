import java.util.Scanner;

public class FileFilter {
    public static void main(String[] args) {
        int maximumSize = Integer.parseInt(args[0]);
        Scanner kb = new Scanner(System.in);
        while (kb.hasNextLine()) {
            String line = kb.nextLine();
            if (line.length() > 0 && line.charAt(0) == '-' && line.charAt(1) != '-') {
                String[] segments = line.split("\s+");
                int size = Integer.parseInt(segments[3]);
                if (size > maximumSize) System.out.println(segments[4]);
            }
        }
    }
}