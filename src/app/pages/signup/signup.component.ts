import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserService,private snack:MatSnackBar) { }

  //execution
  public user={

    userName:'',
    password:'',
    firstName:'',
    lastName:'',
    email:'',
    phone:'',
    address:'',
    profile:'',
   

  }

  ngOnInit(): void {
  }


   //execution
  formSubmit()
  {
  

    console.log(this.user);
    if(this.user.userName=='' || this.user.userName==null)
    {
      // alert('User is required !!');
      this.snack.open('Username is required !!',' ',{
        duration:1000,
        verticalPosition:'top',
        horizontalPosition:'right',
      });
      return;
    }
    // else{
    //   alert('Submitted');
    // }


 //Validate




  //addUser:UserService
    this.userService.addUser(this.user).subscribe(
      (data:any)=>{
        //success
        console.log(data);
        // alert('success');
        Swal.fire('Successfully Done !!','User Id is '+ data.id , 'success');
        window.location.reload();
     
       

      },
      (error)=>{
         //error
         console.log(error)
        //  alert('Something went wrong');
        this.snack.open('Something Went wrong','',{
          duration:2000,
          verticalPosition:'top',
          horizontalPosition:'right',
        });
      }
    )

  }

}
