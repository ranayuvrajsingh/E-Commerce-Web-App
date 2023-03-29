import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginData={
    userName:'',
    password:'',
  }

  constructor(private snack:MatSnackBar,private login:LoginService) { }

  ngOnInit(): void {
  }


  formSubmit(){
    console.log("login btn clicked");

    // for Username
    if(this.loginData.userName.trim()=='' || this.loginData.userName==null)
    {
this.snack.open('Username Is Required','',{
  duration:2000,
});
   return;

    }

    //For password

    if(this.loginData.password.trim()=='' || this.loginData.password==null)
    {
this.snack.open('password Is Required','',{
  duration:2000,
});
   return;

  }

  //request  to Server to generate-token
  this.login.generateToken(this.loginData).subscribe(
   (data:any)=>{
    console.log("Success");
    console.log(data);

    //Login....
    this.login.loginUser(data.token);

    this.login.getCurrentUser().subscribe(
      (user:any)=>{
        this.login.setUser(user);
        console.log(user);
        //redirect .....Admin: admin-dashboard
        //redrect .......Normal:normal-dashboard
        if(this.login.getUserRole()=='User')
        {
          //admin
          window.location.href='/admin';

        }
        else if(this.login.getUserRole()=='Normal')
        {
          //Normal User
          window.location.href='/userdash';
        }
        else
        {
           this.login.logout();
          
        }


      } ); 
   },
   (error)=>{
    console.log("Error");
    console.log(error);
    this.snack.open("Invalid Details !! Try again",' ',{
      duration:2000,
    })
   }

  )




}

}
