import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jumble {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> words = readWords("words.txt");
        String word = selectRandomWord(words);
        String shuffledWord = shuffleWord(word);
        play(word, shuffledWord);
    }

    static ArrayList<String> readWords(String filepath) throws FileNotFoundException {
        File file = new File(filepath);
        Scanner scan = new Scanner(file);

        ArrayList<String> words = new ArrayList<>();
        while (scan.hasNextLine()) {
            words.add(scan.nextLine());
        }
        return words;
    }

    static String selectRandomWord(ArrayList<String> words) {
        Random random = new Random();
        int i = random.nextInt(0, words.size());
        return words.get(i);
    }

    static String shuffleWord(String word) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            indices.add(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        while (indices.size() > 0) {
            int i = random.nextInt(0, indices.size());
            int j = indices.remove(i);
            stringBuilder.append(word.charAt(j));
        }
        return stringBuilder.toString();
    }

    static boolean userGuessCorrect(String userInput, String word) {
        return userInput.equals(word);
    }

    static void play(String word, String shuffledWord) {
        Scanner kb = new Scanner(System.in);
        String userInput = "";
        while (!userGuessCorrect(userInput, word)) {
            System.out.println("-".repeat(40));
            System.out.println(shuffledWord);
            System.out.println("Enter your guess: ");
            userInput = kb.nextLine();
        }
        System.out.println("Congratulations! The word is " + word);
    }
}
