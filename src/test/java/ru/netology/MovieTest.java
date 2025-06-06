package ru.netology;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    @DisplayName("Конструктор должен корректно устанавливать название")
    public void movieConstructor_ShouldSetTitle() {
        Movie movie = new Movie("Inception");
        assertEquals("Inception", movie.getTitle());
    }

    @Test
    @DisplayName("Конструктор должен корректно обрабатывать null название")
    public void movieConstructor_ShouldHandleNullTitle() {
        Movie movie = new Movie(null);
        assertNull(movie.getTitle());
    }

    @Test
    @DisplayName("Метод equals должен возвращать true для одинаковых объектов и объектов с одинаковым названием")
    public void movieEquals_ShouldBehaveCorrectly() {
        Movie movie1 = new Movie("Inception");
        Movie movie2 = new Movie("Inception");
        Movie movie3 = new Movie("The Matrix");

        assertEquals(movie1, movie1); // тот же объект
        assertEquals(movie1, movie2); // разные объекты, одинаковое название
        assertNotEquals(movie1, movie3); // разные названия
        assertFalse(movie1.equals(null)); // сравнение с null
        assertFalse(movie1.equals("Some String")); // сравнение с другим классом
    }

    @Test
    @DisplayName("Метод hashCode должен возвращать одинаковое значение для одинаковых названий")
    public void movieHashCode_ShouldReturnSameHashForSameTitle() {
        Movie movie1 = new Movie("Inception");
        Movie movie2 = new Movie("Inception");
        assertEquals(movie1.hashCode(), movie2.hashCode());
    }

    @Test
    @DisplayName("Метод hashCode должен возвращать разные значения для разных названий")
    public void movieHashCode_ShouldReturnDifferentHashForDifferentTitles() {
        Movie movie1 = new Movie("Inception");
        Movie movie2 = new Movie("The Matrix");
        assertNotEquals(movie1.hashCode(), movie2.hashCode());
    }

    @Test
    @DisplayName("Метод toString должен возвращать название фильма")
    public void movieToString_ShouldReturnTitle() {
        Movie movie = new Movie("Inception");
        assertEquals("Inception", movie.toString());
    }
}
