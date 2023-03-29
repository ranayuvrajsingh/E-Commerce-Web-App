import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addnewproduct',
  templateUrl: './addnewproduct.component.html',
  styleUrls: ['./addnewproduct.component.css']
})
export class AddnewproductComponent implements OnInit {

  constructor(private productService:ProductService,private snack:MatSnackBar) { }

//execution
public product={

  id:'',
  productName:' ',
  price:'',
  description:'',
  availability:'',
  review:'',

}



  ngOnInit(): void {
  }

     //execution
  formSubmit()
  {
  

    console.log(this.product);
    if(this.product.productName=='' || this.product.productName==null)
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
    this.productService.addProduct(this.product).subscribe(
      (data:any)=>{
        //success
        console.log(data);
        // alert('success');
        Swal.fire('Successfully Done !!','Product Id is '+ data.id , 'success');

     
       

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

