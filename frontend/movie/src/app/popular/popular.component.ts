import { Component, OnInit } from '@angular/core';
import { MovieService } from '../service/movie.service';

@Component({
  selector: 'app-popular',
  templateUrl: './popular.component.html',
  styleUrls: ['./popular.component.css']
})
export class PopularComponent implements OnInit {
  movies: any = []
  allMovies: any = []
  currentPg:number=1;
  constructor(private movieS: MovieService) {
    this.getMovies();
  }
  ngOnInit(): void {
  }
  getMovies() {
    this.movieS.popular().subscribe(res => {
      this.movies = res;
      this.allMovies = this.movies.results;
    })

  }
  movieDetails(data: any) {
    console.log(data);
    this.movieS.selectedMovie(data);
  }
 

}
