import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ProductServiceService } from 'src/app/shared/product-service.service';

@Component({
  selector: 'app-register-product',
  templateUrl: './register-product.component.html',
  styleUrls: ['./register-product.component.css']
})
export class RegisterProductComponent implements OnInit{


constructor(public fb:FormBuilder,public cs:ProductServiceService){ }

 public loginform:FormGroup;

  ngOnInit(){
    this.loginform=this.fb.group({
      productId:[this.cs.prd.productId],
      productName:[this.cs.prd.productName],
      productPrice:[this.cs.prd.productPrice]
    })
  }

  addProduct(){
   this.cs.prd=this.loginform.value

   
    this.cs.addProduct(this.cs.prd).subscribe()  
   window.location.reload()
  }



  









}
