import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Represents a database for storing and managing a collection of movies.
 */
public class MovieDB {
    static class MovieNotFoundException extends Exception {
        public MovieNotFoundException(String title) {
            super("The movie " + title + " is not found in the database!");
        }
    }

    HashMap<String, Movie> movies;
    String dbFilepath;

    /**
     * Constructs a new MovieDB instance with a specified file path for data persistence.
     *
     * @param filepath The file path to the database.
     */
    public MovieDB(String filepath){
        dbFilepath = filepath;
        movies = new HashMap<>();
    }

    /**
     * Loads movies from the database file into the movie collection.
     *
     * @throws FileNotFoundException If the database file is not found.
     */
    public void loadMovies() throws FileNotFoundException {
        // Set the delimiter to a regex that matches commas and end-of-line characters
        File file = new File(dbFilepath);
        Scanner scan = new Scanner(file);
        scan.useDelimiter(",|\\r\\n|\\n");
        while (scan.hasNext()) {
            String title = scan.next();
            String genra = scan.next();
            double averageRating = scan.nextDouble();
            int ratingsCount = scan.nextInt();
            Movie movie = new Movie(title, genra, ratingsCount, averageRating);
            this.addMovie(movie);
        }
        scan.close();
    }

    /**
     * Saves the current list of movies to the database file.
     *
     * @throws IOException If an I/O error occurs writing to the file.
     */
    public void saveMovies() throws IOException {
        FileWriter fileWriter = new FileWriter(dbFilepath);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        for (Map.Entry<String, Movie> entry : movies.entrySet()) {
            Movie m = entry.getValue();
            String movieEntry = m.getTitle() + "," + m.getGenre() + "," + m.getAverageRating() + "," + m.getRatingsCount();
            writer.write(movieEntry);
            writer.newLine();
        }
        writer.close();
        fileWriter.close();
    }

    /**
     * Adds a new movie to the database.
     *
     * @param newMovie The movie to add.
     */
    public void addMovie(Movie newMovie) {
        movies.put(newMovie.getTitle(), newMovie);
    }

    /**
     * Prints the list of movies in the database to the console.
     */
    public void listMovies() {
        System.out.println("=".repeat(60));
        if (movies.isEmpty()) {
            System.out.println("Sorry, there are no movies in the database");
            return;
        }
        System.out.println("Movies in the database:");
        System.out.println("-".repeat(60));
        for (Map.Entry<String, Movie> entry : movies.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("=".repeat(60));
    }

    /**
     * Finds and returns a movie in the database by title.
     *
     * @param title The title of the movie to find.
     * @return The found movie.
     * @throws MovieNotFoundException If the movie is not found in the database.
     */
    public Movie findMovie(String title) throws MovieNotFoundException {
        if (!movies.containsKey(title)) throw new MovieNotFoundException(title);
        return movies.get(title);
    }

    /**
     * Deletes a movie from the database by title.
     *
     * @param title The title of the movie to delete.
     * @throws MovieNotFoundException If the movie is not found in the database.
     */
    public void deleteMovie(String title) throws MovieNotFoundException {
        if (!movies.containsKey(title)) throw new MovieNotFoundException(title);
        movies.remove(title);
    }
}
