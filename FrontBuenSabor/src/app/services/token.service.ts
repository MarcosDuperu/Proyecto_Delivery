import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

const TOKEN_KEY = 'AuthToken';

@Injectable({
  providedIn: 'root',
})
export class TokenService {
  roles: Array<string> = [];

  constructor(private router: Router) {}

  public setToken(token: string): void {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string {
    const token_key = sessionStorage.getItem(TOKEN_KEY);
    return token_key;
    //return sessionStorage.getItem(TOKEN_KEY);
  }

  public isLogged(): boolean {
    if(this.getToken()) {
      return true;
    }
    return false;
  }

  public getUserName(): string {
    if(this.isLogged()){
      return null;
    }
    const token = this.getToken();
    const payload = token.split('.')[1];
    const payloadDecode =atob(payload);
    const values = JSON.parse(payloadDecode);
    const username = values.sub;
    return username;
  }

  public isAdmin(): boolean {
    if(this.isLogged()){
      return false;
    }
    const token = this.getToken();
    const payload = token.split('.')[1];
    const payloadDecode =atob(payload);
    const values = JSON.parse(payloadDecode);
    const roles = values.roles;
    if(roles.indexOf('ROLE_ADMIN') < 0) {
      return false;
    }
    return true;
  }

  public logOut(): void {
    window.sessionStorage.clear();
    this.router.navigate(['/']);
  }
}
