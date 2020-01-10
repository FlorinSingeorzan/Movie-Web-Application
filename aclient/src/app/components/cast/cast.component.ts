import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {StaffService} from '../../shared/staff/staff.service';
import {Staff} from '../../shared/models/staff.model';

@Component({
  selector: 'app-cast',
  templateUrl: './cast.component.html',
  styleUrls: ['./cast.component.css']
})
export class CastComponent implements OnInit {

  id: number;
  private sub: any;
  cast: Array<Staff>;

  constructor(private route: ActivatedRoute,
        private staffService: StaffService,

  ) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id'];
    });
    this.staffService.getMovieCast(this.id).subscribe( data => {
      this.cast = data;
    });
  }

}
