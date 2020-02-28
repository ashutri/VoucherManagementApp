import { NgModule,CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';

const routes: Routes = [
  
  { path: 'merchant', component: AdminComponent },
  
];

@NgModule({
  declarations: [AdminComponent],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
     [RouterModule.forRoot(routes)]
    
  ], 
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  exports: [RouterModule]
  
})
export class AdminModule { }
