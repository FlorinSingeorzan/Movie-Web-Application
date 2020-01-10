import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Staff} from '../models/staff.model';
import {Observable} from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class StaffService {

  constructor(private http: HttpClient) { }

  public createStaff(staff) {
    return this.http.post<Staff>('http://localhost:8080/api/staffs/create', staff, httpOptions);
  }

  public getMovieCast(id): Observable<any> {
    return this.http.get('http://localhost:8080/actors/' + id);
  }
}
