package ru.netology;

public class MovieManager {
    private Movie[] movies;
    private int limit;

    // Конструктор по умолчанию (лимит 5)
    public MovieManager() {
        this.limit = 5;
        this.movies = new Movie[0];
    }

    // Конструктор с параметром
    public MovieManager(int limit) {
        this.limit = limit;
        this.movies = new Movie[0];
    }

    // Метод для добавления нового фильма
    public void addMovie(Movie movie) {
        if (movies.length >= limit) {
            throw new IllegalStateException("Cannot add more than " + limit + " movies.");
        }

        Movie[] newMovies = new Movie[movies.length + 1];
        System.arraycopy(movies, 0, newMovies, 0, movies.length);
        newMovies[newMovies.length - 1] = movie;
        movies = newMovies;
    }

    // Метод для получения всех фильмов
    public Movie[] findAll() {
        return movies;
    }

    // Метод для получения последних добавленных фильмов
    public Movie[] findLast() {
        int resultLength = Math.min(limit, movies.length);
        Movie[] result = new Movie[resultLength];

        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}
