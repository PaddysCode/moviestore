package com.paddy.moviestore.repositories;

import com.paddy.moviestore.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {



}
