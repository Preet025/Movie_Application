import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  redirectUrl: string = "";
  constructor(private router: Router) { }
  _isLoggedIn: boolean = false;
  login() {
    this._isLoggedIn = true;
    return this._isLoggedIn;
  }
  logout() {
    this._isLoggedIn = false;
    this.router.navigate(['/auth/login']);
    return this._isLoggedIn;

  }
}
