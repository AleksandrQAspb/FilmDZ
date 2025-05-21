import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerTest {

    @Test
    public void testAddMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Inception");
        Movie[] movies = manager.findAll();
        assertEquals(1, movies.length);
        assertEquals("Inception", movies[0].getTitle());
    }

    @Test
    public void testFindAll() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Inception");
        manager.addMovie("Interstellar");
        Movie[] movies = manager.findAll();
        assertEquals(2, movies.length);
        assertEquals("Inception", movies[0].getTitle());
        assertEquals("Interstellar", movies[1].getTitle());
    }

    @Test
    public void testFindLastDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Inception");
        manager.addMovie("Interstellar");
        manager.addMovie("Dunkirk");
        Movie[] movies = manager.findLast();
        assertEquals(3, movies.length);
        assertEquals("Dunkirk", movies[0].getTitle());
        assertEquals("Interstellar", movies[1].getTitle());
        assertEquals("Inception", movies[2].getTitle());
    }

    @Test
    public void testFindLastCustomLimit() {
        MovieManager manager = new MovieManager(2);
        manager.addMovie("Inception");
        manager.addMovie("Interstellar");
        manager.addMovie("Dunkirk");
        Movie[] movies = manager.findLast();
        assertEquals(2, movies.length);
        assertEquals("Dunkirk", movies[0].getTitle());
        assertEquals("Interstellar", movies[1].getTitle());
    }

    @Test
    public void testFindLastMoreThanAvailable() {
        MovieManager manager = new MovieManager(10);
        manager.addMovie("Inception");
        Movie[] movies = manager.findLast();
        assertEquals(1, movies.length);
        assertEquals("Inception", movies[0].getTitle());
    }
}
