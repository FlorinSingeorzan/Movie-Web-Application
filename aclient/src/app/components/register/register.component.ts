import {Component, OnDestroy, OnInit} from '@angular/core';
import { User } from '../../shared/models/user.model';
import {Route, Router} from '@angular/router';
import {UserService} from '../../shared/user/user.service';
import {AppComponent} from '../../app.component';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit, OnDestroy {
  user: User = new User();
  pass: string;

  constructor(private router: Router, public userService: UserService, public app: AppComponent ) {
    this.app.gtoolbar = true;
  }

  performRegister(name): void {
    if (this.user.password === this.pass && this.user.password != null && this.user.name !== null ) {
      this.user.role = 1;
      const resp = this.userService.createUser(this.user).subscribe(data => {
        if (data == null || data === undefined || Number(data) < 0) {
          return;
        } else if (Number(data) > 0) {
          this.userService.role = 'REGULAR';
          this.userService.userId = Number(data);
          // this.router.navigate(['/regular', name]);
          this.router.navigate(['/regular']);
        }
      });
    } else {
      alert('Wrong data!');
    }
  }

  ngOnInit() {
  }

  ngOnDestroy(): void {
  }

}
