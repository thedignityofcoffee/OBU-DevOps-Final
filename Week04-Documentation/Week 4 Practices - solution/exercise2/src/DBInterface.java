import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DBInterface {
    static Scanner kb;
    static MovieDB database;

    public static void main(String[] args) throws IOException {
        database = new MovieDB("movies.csv");
        kb = new Scanner(System.in);
        System.out.println("Welcome to Movie Database!");
        database.loadMovies();
        int userChoice = 5;
        while (userChoice != 0) {
            System.out.println("Press Enter to continue");
            kb.nextLine();
            database.listMovies();
            printMenu();
            userChoice = getUserChoice();
            switch (userChoice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    findMovie();
                    break;
                case 3:
                    rateMovie();
                    break;
                case 4:
                    deleteMovie();
                    break;
                default:
                    assert userChoice == 0;
                    System.out.print("Do you want to save your changes? [Y/N] ");
                    String userDecision = kb.nextLine();
                    if (userDecision.equalsIgnoreCase("y")) {
                        database.saveMovies();
                        System.out.println("Changes saved to the database!");
                    }
                    System.out.println("Thank you for using Movie Database!");
                    System.out.println("Have a good day!");
                    System.out.println("*".repeat(60));
            }
        }



    }

    static void addMovie() {
        System.out.println("Add a movie");
        System.out.println("-".repeat(60));
        System.out.print("Title: ");
        String title = kb.nextLine();
        System.out.print("Genre: ");
        String genre  = kb.nextLine();
        Movie newMovie = new Movie(title, genre);
        database.addMovie(newMovie);
        System.out.println("Movie added!");
    }

    static void findMovie() {
        System.out.println("Find a movie");
        System.out.println("-".repeat(60));
        System.out.print("Title: ");
        String title = kb.nextLine();
        try {
            Movie movie = database.findMovie(title);
            System.out.println("+".repeat(60));
            System.out.print("Here's your movie: ");
            System.out.println(movie);
            System.out.println("+".repeat(60));
        } catch (MovieDB.MovieNotFoundException e) {
            System.out.println(e);
        }
    }

    static void rateMovie() {
        System.out.println("Rate a movie");
        System.out.println("-".repeat(60));
        System.out.print("Title: ");
        String title = kb.nextLine();
        try {
            Movie movie = database.findMovie(title);
            System.out.println("current rating: " + movie.getAverageRating());
            System.out.print("Your rating: ");
            double newRating = kb.nextDouble();
            movie.rate(newRating);
            kb.nextLine(); // get ready to read the next input
            System.out.println("New rating: " + movie.getAverageRating());
        } catch (MovieDB.MovieNotFoundException e) {
            System.out.println(e);
        }
    }

    static void deleteMovie(){
        System.out.println("Delete a movie");
        System.out.println("-".repeat(60));
        System.out.print("Title: ");
        String title = kb.nextLine();
        try {
            database.deleteMovie(title);
            System.out.println("Movie deleted!");
        } catch (MovieDB.MovieNotFoundException e) {
            System.out.println(e);
        }
    }

    static void printMenu() {
        System.out.println("What do you want to do next?");
        System.out.println("1. add a new movie");
        System.out.println("2. find a movie");
        System.out.println("3. rate a movie");
        System.out.println("4. delete a movie");
        System.out.println("0. exit");
    }

    static int getUserChoice() {
        while (!kb.hasNextInt()) {
            System.out.println("Please enter an integer!");
            kb.nextLine();
        }
        int userChoice = kb.nextInt();
        while (userChoice < 0 || userChoice > 4) {
            System.out.println("Option not valid!");
            userChoice = kb.nextInt();
        }
        kb.nextLine(); // get ready to read the next input
        return userChoice;
    }
}
