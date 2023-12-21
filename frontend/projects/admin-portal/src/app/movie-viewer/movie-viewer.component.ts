import { Component } from '@angular/core';
import { Movie } from '../movie-data/movie';
import { OnInit } from '@angular/core';
import { MovieDataService } from '../movie-data/movie-data.service';
import { CommonModule, NgFor } from '@angular/common';

@Component({
  selector: 'app-movie-viewer',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './movie-viewer.component.html',
  styleUrl: './movie-viewer.component.scss'
})
export class MovieViewerComponent implements OnInit {

  public movies: Movie[] = [];

  public constructor(private movieService: MovieDataService){}

  public ngOnInit(): void {
   this.movieService.getAllMovies().subscribe(
    (movies: Movie[]) => {
      this.movies = movies;
    });
  }

  

  
}
