import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerTest {

    @Test
    public void testAddMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Inception");
        Movie[] movies = manager.findAll();
        Movie[] expectedMovies = {new Movie("Inception")};
        assertArrayEquals(expectedMovies, movies);
    }

    @Test
    public void testFindAll() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Inception");
        manager.addMovie("Interstellar");
        Movie[] movies = manager.findAll();
        Movie[] expectedMovies = {new Movie("Inception"), new Movie("Interstellar")};
        assertArrayEquals(expectedMovies, movies);
    }

    @Test
    public void testFindLastWithLessThanLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Inception");
        manager.addMovie("Interstellar");
        Movie[] movies = manager.findLast();
        Movie[] expectedMovies = {new Movie("Interstellar"), new Movie("Inception")};
        assertArrayEquals(expectedMovies, movies);
    }

    @Test
    public void testFindLastWithExactlyLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Inception");
        manager.addMovie("Interstellar");
        manager.addMovie("Dunkirk");
        Movie[] movies = manager.findLast();
        Movie[] expectedMovies = {new Movie("Dunkirk"), new Movie("Interstellar"), new Movie("Inception")};
        assertArrayEquals(expectedMovies, movies);
    }

    @Test
    public void testFindLastWithMoreThanLimit() {
        MovieManager manager = new MovieManager(2);
        manager.addMovie("Inception");
        manager.addMovie("Interstellar");
        manager.addMovie("Dunkirk");
        Movie[] movies = manager.findLast();
        Movie[] expectedMovies = {new Movie("Dunkirk"), new Movie("Interstellar")};
        assertArrayEquals(expectedMovies, movies);
    }

    @Test
    public void testFindLastWhenEmpty() {
        MovieManager manager = new MovieManager();
        Movie[] movies = manager.findLast();
        Movie[] expectedMovies = {}; // Ожидаемый пустой массив
        assertArrayEquals(expectedMovies, movies);
    }

    @Test
    public void testFindLastWithNoMovies() {
        MovieManager manager = new MovieManager();
        Movie[] movies = manager.findLast();
        Movie[] expectedMovies = {}; // Ожидаем пустой массив
        assertArrayEquals(expectedMovies, movies); // Сравниваем массивы
    }

    @Test
    public void testFindAllWithNoMovies() {
        MovieManager manager = new MovieManager();
        Movie[] movies = manager.findAll();
        Movie[] expectedMovies = {}; // Ожидаем пустой массив
        assertArrayEquals(expectedMovies, movies); // Сравниваем массивы
    }

    @Test
    public void testFindLastNoMovies() {
        MovieManager manager = new MovieManager();
        Movie[] movies = manager.findLast();
        Movie[] expectedMovies = {}; // Ожидаемый массив пустой
        assertArrayEquals(expectedMovies, movies); // Сравниваем массивы
    }

    @Test
    public void testFindLastWithOneMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Inception");
        Movie[] movies = manager.findLast();
        Movie[] expectedMovies = {new Movie("Inception")}; // Ожидаемый массив с одним фильмом
        assertArrayEquals(expectedMovies, movies); // Сравниваем массивы
    }

}
