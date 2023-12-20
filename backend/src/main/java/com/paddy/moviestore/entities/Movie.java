package com.paddy.moviestore.entities;


import jakarta.persistence.*;

import java.util.Objects;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Movie {

    private String name;

    @Id
    @SequenceGenerator(name = "movie_id_sequence", sequenceName = "movie_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_id_sequence")
    private int id;
    private String genre;
    private int releaseyear;

    public Movie(String name, int id, String genre, int releaseyear) {
        this.name = name;
        this.id = id;
        this.genre = genre;
        this.releaseyear = releaseyear;
    }

    public Movie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(int releaseyear) {
        this.releaseyear = releaseyear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && releaseyear == movie.releaseyear && Objects.equals(name, movie.name) && Objects.equals(genre, movie.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, genre, releaseyear);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", genre='" + genre + '\'' +
                ", releaseyear=" + releaseyear +
                '}';
    }
}


