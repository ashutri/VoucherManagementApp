import { NgModule,CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { ConsumerComponent } from './consumer/consumer.component';

const routes: Routes = [
  
  { path: 'merchant', component: ConsumerComponent },
  
];

@NgModule({
  declarations: [ConsumerComponent],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
     [RouterModule.forRoot(routes)]
    
  ], 
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  exports: [RouterModule]
  
})
export class ConsumerModule { }
