import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {map} from 'rxjs/operators';
import { User} from '../models/user.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable()
export class UserService {

  role: string;
  userId: number;

  constructor(private http: HttpClient) {
    this.role = 'NONE';
    this.userId = -1;
  }

  getAll(): Observable<any> {
    // console.log(this.http.get('api/users').pipe(map((response: Response) => response.json())));
    return this.http.get('http://localhost:8080/api/users');
  }

  public createUser(user) {
    console.log(user);
    return this.http.post<User>('http://localhost:8080/api/users/create', user, httpOptions);
  }

  public verifyUser(username) {
    return this.http.get('http://localhost:8080/api/user/' + username);
  }


  deleteUser(userId) {
    return this.http.delete('http://localhost:8080/api/users/' + userId);
  }
}
