import { Component, OnInit } from '@angular/core';
import {User} from '../../shared/models/user.model';
import {Router} from '@angular/router';
import {UserService} from '../../shared/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = new User();
  constructor(private router: Router, private userService: UserService) { }

  performLogin(): void {
    const resp = this.userService.verifyUser(this.user.name).subscribe(data => {
        if (data === null || data === undefined) {
          alert('Wrong Username');
          return;
        }
        if (data['password'] === this.user.password) {
          this.userService.userId = data['id'];
          if (data['role'] === 1) {
            this.userService.role = 'REGULAR';
            this.router.navigate(['/regular']);
          } else if (data['role'] === 0) {
            this.userService.role = 'ADMIN';
            this.router.navigate(['/admin']);
          }
        }
    });
  }

  ngOnInit() {
  }

}
