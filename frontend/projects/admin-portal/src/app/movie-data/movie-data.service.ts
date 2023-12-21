import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Movie } from './movie';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieDataService {

  private baseUrl = `http://localhost:8080/api/`

  constructor(private httpClient: HttpClient) { }

  public getAllMovies(): Observable<Movie[]> {

    const url = `${this.baseUrl}movies`;
    return this.httpClient
      .get<Movie[]>(url)
      .pipe(map(movies => { 
        return movies}));
  }
}
