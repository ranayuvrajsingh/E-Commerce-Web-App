import { Component, OnInit } from '@angular/core';
import { product } from 'src/app/services/Datatype';
import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-productinfo',
  templateUrl: './productinfo.component.html',
  styleUrls: ['./productinfo.component.css']
})
export class ProductinfoComponent implements OnInit {
  productList:undefined | product[];

  // product=[
  //   {
  //     id:1,
  //     name:'Samsung',
  //     description:'this is testing',

  //   },
  //   {
  //     id:2,
  //     name:'Nokia',
  //     description:'this is testing',

  //   },
  //   {
  //     id:3,
  //     name:'Apple',
  //     description:'this is testing',

  //   },
  // ]

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
