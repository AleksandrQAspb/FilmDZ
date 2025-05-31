package ru.netology;

import java.util.Objects;

public class Movie {
    private String title;

    // Конструктор
    public Movie(String title) {
        this.title = title;
    }

    // Метод для получения названия фильма
    public String getTitle() {
        return title;
    }

    // Переопределение метода toString для удобного отображения
    @Override
    public String toString() {
        return title;
    }

    // Переопределение метода equals для сравнения объектов Movie
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title);
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}

