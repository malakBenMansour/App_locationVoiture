import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../service/token-storage.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  title = 'appLocationVoiture';
  isShown: boolean = false ; // hidden by default
  toggleShow() {
    this.isShown = ! this.isShown;

  }
/////
  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username?: string;
  user =  this.tokenStorageService.getUser();
  admin : any ;




  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      this.admin = this.user.roles.includes("ROLE_ADMIN");

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
   

      this.username = user.username;
    }
  }

logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
  }

 
}
