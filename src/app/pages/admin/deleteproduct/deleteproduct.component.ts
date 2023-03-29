import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { product } from 'src/app/services/Datatype';
import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-deleteproduct',
  templateUrl: './deleteproduct.component.html',
  styleUrls: ['./deleteproduct.component.css']
})
export class DeleteproductComponent implements OnInit {
  productList:undefined | product[];
  productMessage:undefined|String;



  
   constructor(private product:ProductService,private router:Router) { }



    //execution
 

  ngOnInit(): void {

    this.product.productList().subscribe(
    (data:any) => 
    {
      
      this.productList=data;
      console.log(this.product);

    },
    (error)=>
    {
      console.log(error);
      Swal.fire('Error !!','Error in Deleting Data','error');
    }


    )
  }


  deleteProduct(id: any){
    console.warn(id)
    console.log("this is inside the delete segemt")
    this.product.deleteProduct(id).subscribe(
      (data:any) => 
      {
        
        this.productList=data;
        console.log(this.product);
        Swal.fire(' Successful !!','Product is Deleted Successfully');
        window.location.reload();
  
      },
      (error)=>
      {
        console.log(error);
        Swal.fire('Error !!','Error in Deleting Data','error');
      }
    )

  }

  updateProduct(id: any){
    console.warn(id)
    console.log("this is inside the Update segemt")
     //get product based on id
   let currentProduct= this.productList?.find((p) => {return p.id === id});
   console.log(currentProduct);
  }

}
