import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpModule } from '@angular/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import { ConsumerModule } from '../consumer/consumer.module';
import { AdminModule } from '../admin/admin.module';
import { LoginModule } from '../login/login.module';
import { MerchantModule } from '../merchant/merchant.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpModule,
    BrowserAnimationsModule,
    ConsumerModule,
    AdminModule,
    LoginModule,
    MerchantModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
