import { Component, OnInit } from '@angular/core';
import {UserService} from '../../shared/user/user.service';

@Component({
  selector: 'app-ulist',
  templateUrl: './ulist.component.html',
  styleUrls: ['./ulist.component.css']
})
export class UlistComponent implements OnInit {
  users: Array<any>;
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getAll().subscribe(data => {
      this.users = data;
  });

}
}
