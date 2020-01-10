import { Injectable } from '@angular/core';
import {User} from '../models/user.model';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Staff} from '../models/staff.model';
import {Role} from '../models/role.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  constructor(private http: HttpClient) { }

  public createRole(role) {
    return this.http.post<Role>('http://localhost:8080/api/roles/create', role, httpOptions);
  }
}
