import java.util.ArrayList;

public class MovieManager {
    private ArrayList<Movie> movies;
    private int limit;

    // Конструктор по умолчанию
    public MovieManager() {
        this.limit = 5;
        this.movies = new ArrayList<>();
    }

    // Конструктор с параметром
    public MovieManager(int limit) {
        this.limit = limit;
        this.movies = new ArrayList<>();
    }

    // Метод для добавления нового фильма
    public void addMovie(String title) {
        Movie movie = new Movie(title);
        movies.add(movie);
    }

    // Метод для получения всех фильмов
    public Movie[] findAll() {
        return movies.toArray(new Movie[0]);
    }

    // Метод для получения последних добавленных фильмов
    public Movie[] findLast() {
        int resultLength = Math.min(movies.size(), limit);
        Movie[] result = new Movie[resultLength];

        for (int i = 0; i < resultLength; i++) {
            result[i] = movies.get(movies.size() - 1 - i);
        }

        return result;
    }
}

