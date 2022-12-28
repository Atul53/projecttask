import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../product';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

constructor(public http:HttpClient) { }

public prd:Product={
  productId:0,
	productName:'',
	productPrice:0
}

//POSTAPI
addProduct(prd:Product){
 return this.http.post("http://localhost:9091/api/product",prd)
}

//GETAPI
showProduct(){
  return this.http.get("http://localhost:9091/api/products")
}

//PUTAPI
updateProduct(prd:Product){
  return this.http.put("http://localhost:9091/api/product/"+prd.productId,prd)
}


//DELETEAPI
deleteProduct(productId:number){
  return this.http.delete("http://localhost:9091/api/product/"+productId)
}








}
