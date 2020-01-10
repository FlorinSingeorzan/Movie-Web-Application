import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {User} from '../models/user.model';
import {Feedback} from '../models/feedback.model';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  constructor(private http: HttpClient) { }

  public createFeedback(feedback) {
    return this.http.post<Feedback>('http://localhost:8080/api/feedbacks/create', feedback, httpOptions);
  }

  public findSpecificFeedback(movieId, userId) {
    return this.http.get<Feedback>('http://localhost:8080/api/feedbacks/' + movieId + '/' + userId);
  }

  public appendReview(feedback) {
    return this.http.post<string>('http://localhost:8080/addFeedback/REVIEW', feedback, httpOptions);

  }

  findMovieFeedbacks(movieId): Observable<any> {
    return this.http.get('http://localhost:8080/api/mfeedbacks/' + movieId);
  }

  setWatched(feedback) {
    return this.http.post<string>('http://localhost:8080/addFeedback/REVIEW', feedback, httpOptions);
  }
}
