import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MainService {

  constructor(private httpClient: HttpClient, private router: Router) { }
  redirectUrl: string = "";
  isLoggedIn: boolean = false;
  logdata: any;
  customerId: any;
  i: any;
  email: any;

  // register service
  registerUser(RegistrationForm: any) {
    console.log(" services works..");
    console.log(RegistrationForm);
    const registerObservable = this.httpClient.post<any>('http://localhost:8081/api/v2/register', RegistrationForm);
    alert("Registered Successfully!!!");
    this.router.navigate(['/auth/login']);
    return registerObservable;
  }

  getUser() {
    return this.httpClient.get<any>("http://localhost:8081/api/v2/registers/" + this.email);
  }

  // login register service ts
  HttpLogin(data: any) {
    return this.httpClient.post("http://localhost:8085/api/v1/login", data);
  }

}
