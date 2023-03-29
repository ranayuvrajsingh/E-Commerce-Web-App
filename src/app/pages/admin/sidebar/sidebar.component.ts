import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  isLoggedIn=false;              //changed for user login error

  user=null;                     //changed for user login error

  constructor(public login:LoginService) { }

  ngOnInit(): void {
    this.isLoggedIn=this.login.isLoggedIn();          //changed for user login error
    this.user=this.login.getUser();                      //changed for user login error
  }

  public logout()
  {
    this.login.logout();
    window.location.reload();
  }

  

}
