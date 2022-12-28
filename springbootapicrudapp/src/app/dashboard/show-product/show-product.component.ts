import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/product';
import { ProductServiceService } from 'src/app/shared/product-service.service';

@Component({
  selector: 'app-show-product',
  templateUrl: './show-product.component.html',
  styleUrls: ['./show-product.component.css']
})
export class ShowProductComponent {

  constructor(public cs:ProductServiceService){}
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
    show:boolean=true
    public btnname:string='showdata'
    public productlist:Product[]

  showProduct(){
    this.show=!this.show
    if(this.show){
    this.btnname='showdata'
    window.location.reload()
    }else{
      this.btnname='Hidedata'
      this.cs.showProduct().subscribe((productdb:any)=>{
        this.productlist=productdb.responseData;
        alert(productdb.msg)
      })
    }
   }

   updateProduct(pre:Product){
    this.cs.prd=Object.assign({},pre)
   }

   deleteProduct(productId:number){
    this.cs.deleteProduct(productId).subscribe()
    window.location.reload()
   }

}
