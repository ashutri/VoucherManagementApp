import { Component, OnInit, Input } from '@angular/core';
import { Admin } from "../admin";
import { Consumer } from "../../consumer/consumer";
import { AdminService } from "../admin.service";
import { ConsumerService } from "../../consumer/consumer.service";
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormBuilder, FormGroup, FormArray, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
  providers: [AdminService, HttpClient]
})
export class AdminComponent implements OnInit {
  
  selectedContact;
  successMessage: string;
  addSuccess = false;
  consumer:Consumer;
  mobile:number;
  private voucherId: string;
  vArray: Array<string> = []; 
  private admins: Admin[];
  constructor(private router: Router,
    private adminService: AdminService,private conService: ConsumerService) {
      
    }
  ngOnInit() {
    this.getAllProducts();
    
  }
  
  getNumber()
  {
    this.consumer={
      vArray:this.vArray,
      mobile:this.mobile
    }
    this.conService.create(this.consumer);
    this.addSuccess = true;
    this.successMessage = 'Vouchers added to '+this.mobile;
  }

  addVoucher(voucherId:string, event){ 
    if(event.srcElement.innerHTML ==='+' ){
      //// perform add action
      event.srcElement.innerHTML="@";
    }   
    this.vArray.push(voucherId);
    console.log(this.vArray);
  }
  getAllProducts() {
    this.adminService.findAll().then(
      admins => {
        this.admins = admins;
      },
      err => {
        console.log(err);
      }
    );
  }
  create() {
    let num = 5;
    
    this.adminService.create(num).then(
      admins => {
        this.admins = admins;
      },
      err => {
        console.log(err);
      }
    );
  }

  public selectContact(admin){
    this.selectedContact = admin;
  }
}
