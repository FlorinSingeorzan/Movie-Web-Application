import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../models/user.model';
import {Movie} from '../models/movie.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private http: HttpClient) { }


  getMovies(select, userId): Observable<any> {
    if (select === 'regular') {
    return this.http.get('http://localhost:8080/api/movies');
    } else if (select === 'watchlist') {
      return this.http.get('http://localhost:8080/watched/' + userId);
    } else if (select === 'top') {
      return this.http.get('http://localhost:8080/highrate/8');
    }
  }

  public createMovie(movie) {
    return this.http.post<Movie>('http://localhost:8080/api/movies/create', movie, httpOptions);
  }


  public getMovie(id) {
    return this.http.get<Movie>('http://localhost:8080/api/movies/' + id);
  }
}
