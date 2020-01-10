import { Component, OnInit } from '@angular/core';
import {UserService} from '../../shared/user/user.service';
import {Movie} from '../../shared/models/movie.model';
import {Staff} from '../../shared/models/staff.model';
import {Role} from '../../shared/models/role.model';
import {MovieService} from '../../shared/movie/movie.service';
import {StaffService} from '../../shared/staff/staff.service';
import {RoleService} from '../../shared/role/role.service';

@Component({
  selector: 'app-add-content',
  templateUrl: './add-content.component.html',
  styleUrls: ['./add-content.component.css']
})
export class AddContentComponent implements OnInit {

  movie: Movie = new Movie();
  staff: Staff = new Staff();
  role: Role = new Role();
  userId: number;
  logUser: string;

  constructor(public userService: UserService, private movieService: MovieService,
              private staffService: StaffService, private roleService: RoleService) {
  }

  addMovie() {
    this.movieService.createMovie(this.movie).subscribe(data => {
      console.log(data);
      this.movie.id = Number(data);
    });
  }
  addStaff() {
    console.log(this.staff);
    this.staffService.createStaff(this.staff).subscribe(data => {
      this.staff.id = Number(data);
  });
  }
  addRole() {
    this.roleService.createRole(this.role).subscribe(data => {
      console.log(data);
      this.role.id = Number(data);
    });
  }

  deleteUser() {
    this.userService.deleteUser(this.userId).subscribe(data => {
      console.log('deleted');
    });
  }


  ngOnInit() {
    this.logUser = this.userService.role;
  }

}
