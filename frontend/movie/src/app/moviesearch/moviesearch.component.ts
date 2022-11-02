import { Component, OnInit } from '@angular/core';
import { MovieService } from '../service/movie.service';
import { SearchserviceService } from '../service/searchservice.service';

@Component({
  selector: 'app-moviesearch',
  templateUrl: './moviesearch.component.html',
  styleUrls: ['./moviesearch.component.css']
})
export class MoviesearchComponent implements OnInit {

  movies: any = []
  allMovies: any = []
  currentPg:number=1;
  searchStr:any;
  searchRes:any;
  name='';
  constructor(private ms: MovieService, private share:SearchserviceService) {
    this.share.updateName.subscribe(n => this.name=n);
    

    this.getMovies();
   }
  ngOnInit(): void {
  }
  getMovies() {
    this.ms.searchMovies(this.name).subscribe(res => {
      this.movies = res;
      console.log(this.movies);
      this.allMovies = this.movies.results;
      console.log(this.allMovies);
    })
  }
  movieDetails(data: any) {
    console.log(data);
    this.ms.selectedMovie(data);
  }  

}
