import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {MovieService} from '../../shared/movie/movie.service';
import {Movie} from '../../shared/models/movie.model';
import {DomSanitizer } from '@angular/platform-browser';
import {UserService} from '../../shared/user/user.service';
import {FeedbackService} from '../../shared/feedback/feedback.service';
import {Feedback} from '../../shared/models/feedback.model';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  id: number;
  sMovie: Movie = new Movie();
  stars: Array<any>;
  userId: number;
  feedback: Feedback = new Feedback();
  allFeedbacks: Array<any>;
  private sub: any;
  constructor(private route: ActivatedRoute,
              private movieService: MovieService,
              private userService: UserService,
              private sanitizer: DomSanitizer,
              private feedbackService: FeedbackService
              ) { }

  ngOnInit() {
    this.userId = this.userService.userId;
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id'];
    });
    console.log(this.id);
    this.movieService.getMovie(this.id).subscribe(data => {
      this.sMovie = data;
      this.stars = Array(this.sMovie.rate).fill(1);
    });
    console.log(this.userId);
    if (this.userId > 0) {
      this.feedbackService.findSpecificFeedback(this.id, this.userId).subscribe( data => {
        if (data == null || data === undefined) {
          this.feedback.movieId = this.id;
          this.feedback.userId = this.userId;
          this.feedbackService.createFeedback(this.feedback).subscribe( feed => {
              if (feed == null || feed === undefined || Number(feed) < 0) {
                  return;
              } else {
                this.feedback.id = Number(feed);
              }
            }
          );
        } else {
          this.feedback = data;
        }
        console.log(this.feedback);
      });
    }
    this.feedbackService.findMovieFeedbacks(this.id).subscribe( data => {
      this.allFeedbacks  = data;
    });
  }

  addReview() {
    this.feedbackService.appendReview(this.feedback).subscribe(data => {
      console.log(data);
    });
  }

  addWatched() {
    const elem = document.getElementById('tog');
     if (elem.innerHTML  === 'Add to watchlist') {
      elem.innerHTML  = 'Added';
      this.feedback.watched = 1;
      this.feedbackService.setWatched(this.feedback).subscribe(data => {
         console.log('watched');
       });
     } else {
       elem.innerHTML = 'Add to watchlist';
       this.feedback.watched = 0;
       this.feedbackService.setWatched(this.feedback).subscribe(data => {
         console.log('unwatched');
       });
     }
  }

  showCast() {

  }
}
