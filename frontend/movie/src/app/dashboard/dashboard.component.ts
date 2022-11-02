import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { Router } from '@angular/router';
import { MainService } from '../service/main.service';
import { AuthService } from '../service/auth.service';
import { MovieService } from '../service/movie.service';
import { SearchserviceService } from '../service/searchservice.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {


  movies: any = []
  allMovies: any = []
  currentPg:number=1;
  searchStr:any;
  searchRes:any;


  name='';
 
  query:any;
  email: any;
  user: any;
  userName: any;
  userProfileImg: any;
  genderMale:any;
  genderFemale:any;
  searchMovie:any;
  isLogIn: any = this.authS._isLoggedIn;
  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );
sidenav: any;

  constructor(private authS: AuthService, private share:SearchserviceService ,private ms: MovieService,private breakpointObserver: BreakpointObserver, private router: Router, private mainService: MainService) {
this.share.updateName.next(this.name);
   }
  ngOnInit(): void {
    // throw new Error('Method not implemented.');
    this.email = this.mainService.email;
    console.log(this.email);
    // this.mainService.getUser(this.email).subscribe((res: any)=>{
    //   console.log(res);
    // });
    if (this.isLogIn == true) {
      console.log("user by email");
      this.getUserByEmail();
    }
  }
  keyUp(e: KeyboardEvent){
    const target=<HTMLInputElement>e.target;
    this.share.updateName.next(target.value);
  }
  selectFile(){
    this.router.navigate(["moviesearch"]);

  }



  onSubmit() {
    this.router.navigate(['/moviesearch/' + this.query + '/results'], {queryParams: {query: this.query}});
  }



  searchingItems(text: string) {
    if (text.length == 0) {
      return;
    }
    console.log(text);
    this.router.navigate(['/dashboard/search-items', text])
  }
  getUserByEmail() {
    this.mainService.getUser().subscribe(res => {
      this.user = res;
      this.userName = this.user.userName;
      if(this.user.gender=="male"){
        this.genderMale=this.user.gender;
      }
      else{
        this.genderFemale=this.user.gender;
      }
      this.userProfileImg = this.user.profilePicture;
      console.log(this.user);
    });
    // console.log(this.mainService.getUser());
  }
  loggedOut() {
    this.authS.logout();
  }







  getMovies() {
    this.ms.getAllMovies(this.currentPg).subscribe(res => {
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

  // form.addEventListner('submit', (e)=>{
  //   e.preventDefault()
  //    const searchValue=search.value
  //    if(searchValue && searchValue!==''){
  //     getAllMovies(SEARCH_URL+searchValue)
  //     searchValue=''
  //    }else{
  //     window.location.reload()
  //    }
  // })

}
