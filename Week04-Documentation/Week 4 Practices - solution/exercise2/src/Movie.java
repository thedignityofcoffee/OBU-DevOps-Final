/**
 * Represents a movie with a title, genre, ratings count, and average rating.
 */
public class Movie {
    String title;
    String genre;
    double averageRating;
    int ratingsCount;

    /**
     * Constructs a Movie object with the specified title and genre.
     * Initializes ratings count and average rating to 0.
     *
     * @param title The title of the movie.
     * @param genre The genre of the movie.
     */
    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
        this.ratingsCount = 0;
        averageRating = 0;
    }

    /**
     * Constructs a Movie object with the specified title, genre, ratings count, and average rating.
     * Used for loading movies from a CSV file.
     *
     * @param title The title of the movie.
     * @param genre The genre of the movie.
     * @param ratingsCount The number of ratings the movie has received.
     * @param averageRating The average rating of the movie.
     */
    public Movie(String title, String genre, int ratingsCount, double averageRating) {
        this.title = title;
        this.genre = genre;
        this.ratingsCount = ratingsCount;
        this.averageRating = averageRating;
    }

    /**
     * Returns the title of the movie.
     *
     * @return The title of the movie.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the genre of the movie.
     *
     * @return The genre of the movie.
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * Returns the average rating of the movie.
     *
     * @return The average rating of the movie.
     */
    public double getAverageRating() {
        return this.averageRating;
    }

    /**
     * Returns the total number of ratings the movie has received.
     *
     * @return The total number of ratings.
     */
    public int getRatingsCount() {
        return this.ratingsCount;
    }

    /**
     * Updates the movie's average rating based on a new rating score.
     *
     * @param score The new rating score to be added to the movie's average rating.
     */
    public void rate(double score) {
        double totalScore = averageRating * ratingsCount;
        totalScore += score;
        ratingsCount++;
        averageRating = totalScore / ratingsCount;
    }

    /**
     * Returns a string representation of the movie, including its title, genre, and average rating.
     *
     * @return A string representation of the movie.
     */
    public String toString() {
        return title + ": " + genre + "; " + averageRating;
    }
}
