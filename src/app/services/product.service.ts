import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { product } from './Datatype';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  //load all Products

  public productList(){
    return this.http.get<product[]>(`${"http://localhost:8991"}/product/`);
  }



//Add Product

  public addProduct(product:any)
  {
    return this.http.post(`${"http://localhost:8991"}/product/`,product);
  }


//delete Product
// public deleteProduct(productname:String){
//   return this.http.delete(`${"http://localhost:8991"}/productName`)
//   }

  public deleteProduct(id:any){
    return this.http.delete(`${"http://localhost:8991"}/product/${id}`);
    }

    public updateProduct(id:any){
      return this.http.put(`${"http://localhost:8991"}/product/${id}`,this.productList);
    }




}





// return this.http.post(`${"http://localhost:8990"}/user/`,user);
