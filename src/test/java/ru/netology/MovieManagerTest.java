package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    private MovieManager manager;

    @BeforeEach
    public void setUp() {
        manager = new MovieManager();
    }

    @Test
    public void addMovie_ShouldAddMovie() {
        Movie movie = new Movie("Inception");
        manager.addMovie(movie);
        Movie[] movies = manager.findAll();
        assertEquals(1, movies.length);
        assertEquals(movie, movies[0]);
    }

    @Test
    public void findAll_ShouldReturnAllMovies() {
        Movie movie1 = new Movie("Inception");
        Movie movie2 = new Movie("The Matrix");
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        Movie[] movies = manager.findAll();
        assertArrayEquals(new Movie[]{movie1, movie2}, movies);
    }

    @Test
    public void findLast_ShouldReturnLastAddedMovies_Limit5() {
        MovieManager manager = new MovieManager(5);
        for (int i = 0; i < 5; i++) {
            manager.addMovie(new Movie("Movie " + i));
        }

        assertThrows(IllegalStateException.class, () -> {
            manager.addMovie(new Movie("Movie 5"));
        });

        Movie[] lastMovies = manager.findLast();
        assertArrayEquals(new Movie[]{
                new Movie("Movie 4"),
                new Movie("Movie 3"),
                new Movie("Movie 2"),
                new Movie("Movie 1"),
                new Movie("Movie 0")
        }, lastMovies);
    }

    @Test
    public void findLast_ShouldReturnAllMovies_WhenLessThanLimit() {
        manager.addMovie(new Movie("Inception"));
        manager.addMovie(new Movie("The Matrix"));
        Movie[] lastMovies = manager.findLast();
        assertArrayEquals(new Movie[]{
                new Movie("The Matrix"),
                new Movie("Inception")
        }, lastMovies);
    }

    @Test
    void addMovie_ShouldNotExceedLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie(new Movie("Movie 1"));
        manager.addMovie(new Movie("Movie 2"));
        manager.addMovie(new Movie("Movie 3"));

        assertThrows(IllegalStateException.class, () -> {
            manager.addMovie(new Movie("Movie 4"));
        });

        assertEquals(3, manager.findAll().length);
    }

    @Test
    void findLast_ShouldReturnEmptyArray_WhenNoMovies() {
        Movie[] lastMovies = manager.findLast();
        assertEquals(0, lastMovies.length);
    }

    @Test
    void findLast_ShouldReturnMovies_WhenLessThanLimit() {
        manager.addMovie(new Movie("Movie 1"));
        manager.addMovie(new Movie("Movie 2"));
        Movie[] lastMovies = manager.findLast();
        assertArrayEquals(new Movie[]{
                new Movie("Movie 2"),
                new Movie("Movie 1")
        }, lastMovies);
    }

    @Test
    void constructor_ShouldSetLimit() {
        MovieManager manager = new MovieManager(0);
        assertThrows(IllegalStateException.class, () -> {
            manager.addMovie(new Movie("Movie 1"));
        });
    }
}
