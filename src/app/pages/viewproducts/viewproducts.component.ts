import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { product } from 'src/app/services/Datatype';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-viewproducts',
  templateUrl: './viewproducts.component.html',
  styleUrls: ['./viewproducts.component.css']
})
export class ViewproductsComponent implements OnInit {
  productList:undefined | product[];

  constructor(private product:ProductService) { }

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
      Swal.fire('Error !!','Error in Loading Data','error');
    }


    )
  }

}