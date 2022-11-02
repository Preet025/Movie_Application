import { Component, OnInit } from '@angular/core'; 
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { MainService } from '../service/main.service';
import { MovieService } from '../service/movie.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  ngOnInit(): void {
  }
  
  authenticationToken: any = "";
  signin: any;
  LoginForm = new FormGroup({
    email: new FormControl('', [Validators.email, Validators.required]),
    password: new FormControl('', [Validators.required])
  })
  get getEmail() {
    return this.LoginForm.controls['email']
  }
  get getPassword() {
    return this.LoginForm.controls['password']
  }

  constructor(private mainService: MainService, private authService: AuthService, public router: Router, private movieService: MovieService) { }

  onSubmit() {
    console.log(this.LoginForm.value);
  }
  loggedin(): void {
    this.mainService.email = this.LoginForm.value.email;
    this.movieService.email = this.LoginForm.value.email;
    this.mainService.HttpLogin(this.LoginForm.value).subscribe((a) => {
      console.log(a);
      this.authenticationToken = a;
      this.signin = this.authService.login();
      this.router.navigate(["dashboard/home"]);
    },
      err => {
        alert("Invalid username or password");
        this.LoginForm.reset();
      })
    this.LoginForm.reset({});
    console.log("reset");

  }
}
