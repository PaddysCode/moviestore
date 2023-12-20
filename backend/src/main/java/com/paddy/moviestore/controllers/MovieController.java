package com.paddy.moviestore.controllers;


import com.paddy.moviestore.DTOs.MovieDTO;
import com.paddy.moviestore.entities.Movie;
import com.paddy.moviestore.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieController {


    private MovieRepository movieRepository;


    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Movie> getAllMovies(){
       return movieRepository.findAll();
    }


    @PostMapping
    public void createMovie(@RequestBody MovieDTO newMovie){
        Movie entity = new Movie();
        entity.setName(newMovie.name());
        entity.setReleaseyear(newMovie.releaseyear());
        entity.setGenre(newMovie.genre());


        movieRepository.save(entity);
    }

    @DeleteMapping("{movieId}")
    public void deleteMovie(@PathVariable int movieId){
        movieRepository.deleteById(movieId);
    }

    @PutMapping("{movieId}")
    public void updateMovie(@RequestBody MovieDTO newMovie, @PathVariable int movieId){
        Movie entity = movieRepository.findById(movieId).get();
        entity.setName(newMovie.name());
        entity.setReleaseyear(newMovie.releaseyear());
        entity.setGenre(newMovie.genre());

        movieRepository.save(entity);

    }
}
