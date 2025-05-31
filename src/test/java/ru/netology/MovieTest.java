package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    public void movieConstructor_ShouldSetTitle() {
        Movie movie = new Movie("Inception");
        assertEquals("Inception", movie.getTitle());
    }

    @Test
    public void movieConstructor_ShouldHandleNullTitle() {
        Movie movie = new Movie(null);
        assertNull(movie.getTitle());
    }

    @Test
    public void movieEquals_ShouldReturnFalseForDifferentTitles() {
        Movie movie1 = new Movie("Inception");
        Movie movie2 = new Movie("The Matrix");
        assertNotEquals(movie1, movie2);
    }

    @Test
    public void movieEquals_ShouldReturnTrueForSameTitles() {
        Movie movie1 = new Movie("Inception");
        Movie movie2 = new Movie("Inception");
        assertEquals(movie1, movie2);
    }

    @Test
    public void movieHashCode_ShouldReturnSameHashForSameTitle() {
        Movie movie1 = new Movie("Inception");
        Movie movie2 = new Movie("Inception");
        assertEquals(movie1.hashCode(), movie2.hashCode());
    }

    @Test
    public void movieHashCode_ShouldReturnDifferentHashForDifferentTitles() {
        Movie movie1 = new Movie("Inception");
        Movie movie2 = new Movie("The Matrix");
        assertNotEquals(movie1.hashCode(), movie2.hashCode());
    }

    @Test
    public void movieToString_ShouldReturnTitle() {
        Movie movie = new Movie("Inception");
        assertEquals("Inception", movie.toString());
    }

    @Test
    public void movieEquals_ShouldReturnFalseForNull() {
        Movie movie = new Movie("Inception");
        assertFalse(movie.equals(null));
    }

    @Test
    public void movieEquals_ShouldReturnFalseForDifferentClass() {
        Movie movie = new Movie("Inception");
        String otherObject = "Not a Movie";
        assertFalse(movie.equals(otherObject));
    }

    @Test
    public void movieEquals_ShouldReturnTrueForSameObject() {
        Movie movie = new Movie("Inception");
        assertTrue(movie.equals(movie));
    }

    @Test
    public void movieEquals_ShouldReturnTrueForSameTitle() {
        Movie movie1 = new Movie("Inception");
        Movie movie2 = new Movie("Inception");
        assertTrue(movie1.equals(movie2));
    }

    @Test
    public void movieEquals_ShouldReturnFalseForDifferentTitle() {
        Movie movie1 = new Movie("Inception");
        Movie movie2 = new Movie("The Matrix");
        assertFalse(movie1.equals(movie2));
    }

}
