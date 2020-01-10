import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {UserService} from '../../shared/user/user.service';
import {AppComponent} from '../../app.component';
import {MovieService} from '../../shared/movie/movie.service';

@Component({
  selector: 'app-regular',
  templateUrl: './regular.component.html',
  styleUrls: ['./regular.component.css'],
})
export class RegularComponent implements OnInit, OnDestroy {

  logUser: string;
  movies: Array<any>;
  href: string;
  constructor(private route: ActivatedRoute, private userService: UserService, private app: AppComponent,
              private movieService: MovieService) {
    this.app.gtoolbar = false;
    this.app.addcontent = true;
  }

  ngOnInit() {

    this.logUser = this.userService.role;
    this.href = window.location.href.split('/')[3];
    this.movieService.getMovies(this.href, this.userService.userId).subscribe(data => {
      this.movies = data;
    });
    console.log(this.userService.role);
    if(this.logUser=== 'ADMIN'){
      this.app.addcontent = false;
    }
    }

  ngOnDestroy(): void {
    // this.userService.role= 'NONE';
  }
}
