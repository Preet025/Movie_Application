import { Component, OnInit } from '@angular/core';
import { MovieService } from '../service/movie.service';

@Component({
  selector: 'app-tvshows',
  templateUrl: './tvshows.component.html',
  styleUrls: ['./tvshows.component.css']
})
export class TvshowsComponent implements OnInit {
  movies: any = []
  allMovies: any = []
  currentPg:number=1;
  constructor(private movieS: MovieService) {
    this.getMovies();
  }
  ngOnInit(): void {
  }
  getMovies() {
    this.movieS.tvshows().subscribe(res => {
      this.movies = res;
      this.allMovies = this.movies.results;
    })

  }
  movieDetails(data: any) {
    console.log(data);
    this.movieS.selectedMovie(data);
  }
 

}