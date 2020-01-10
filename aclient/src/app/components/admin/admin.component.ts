import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {UserService} from '../../shared/user/user.service';
import {AppComponent} from '../../app.component';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit, OnDestroy {

  logUser: string;
  constructor(private route: ActivatedRoute, public userService: UserService, public app: AppComponent) {
    app.gtoolbar = false;
    app.addcontent = false;
  }

  ngOnInit() {
    console.log(this.userService.role);
    this.logUser = this.userService.role;
  }

  ngOnDestroy(): void {
    // this.userService.role = 'NONE';
  }

}
