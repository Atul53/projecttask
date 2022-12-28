import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterProductComponent } from './dashboard/register-product/register-product.component';
import { ShowProductComponent } from './dashboard/show-product/show-product.component';

const routes: Routes = [
{
  path:'Registerportal',component:RegisterProductComponent
},
{
  path:'showportal',component:ShowProductComponent
}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
