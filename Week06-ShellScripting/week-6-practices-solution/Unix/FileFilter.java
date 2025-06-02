import java.util.Scanner;

public class FileFilter {
    public static void main(String[] args) {
        int maximumSize = Integer.parseInt(args[0]);
        Scanner kb = new Scanner(System.in);
        while (kb.hasNextLine()) {
            String line = kb.nextLine();
            if (line.charAt(0) == '-') {
                String[] segments = line.split("\s+");
                int size = Integer.parseInt(segments[4]);
                if (size > maximumSize) System.out.println(segments[8]);
            }
        }
    }
}