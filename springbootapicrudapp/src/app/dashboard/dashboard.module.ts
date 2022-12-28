import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterProductComponent } from './register-product/register-product.component';
import { ShowProductComponent } from './show-product/show-product.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    RegisterProductComponent,
    ShowProductComponent
  ],
  imports: [
    FormsModule,
    CommonModule,
    ReactiveFormsModule
  ],
  
  exports :[
    RegisterProductComponent,
    ShowProductComponent
  ]
})
export class DashboardModule { }
