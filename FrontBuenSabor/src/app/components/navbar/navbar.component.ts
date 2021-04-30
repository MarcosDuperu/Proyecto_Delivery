import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SocialAuthService, SocialUser } from 'angularx-social-login';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  userLogged: SocialUser;
  isLogged: boolean;

  constructor(
    private authServiceSocial: SocialAuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.authServiceSocial.authState.subscribe((data) => {
      this.userLogged = data;
      this.isLogged = this.userLogged != null;
    });
  }

  logOut(): void {
    this.authServiceSocial.signOut().then((data) => {
      this.router.navigate(['/login']);
    });
  }
}
