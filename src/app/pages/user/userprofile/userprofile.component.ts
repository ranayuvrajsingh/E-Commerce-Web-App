import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent implements OnInit {

  user:any=null;
  constructor(private login:LoginService) { }

  ngOnInit(): void {

    this.user=this.login.getUser();
  }

}
