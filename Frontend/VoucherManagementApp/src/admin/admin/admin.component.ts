import { Component, OnInit, Input } from '@angular/core';
import { Admin } from "../admin";
import { AdminService } from "../admin.service";
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
  form:FormGroup;
  private admins: Admin[];
  constructor(private router: Router,
    private adminService: AdminService, private fb: FormBuilder) {
      this.form = this.fb.group({
        checkArray: this.fb.array([], [Validators.required])
      }) 
    }
  ngOnInit() {
    this.getAllProducts();
  }
  submitForm() {
    console.log(this.form.value)
  }
  onCheckboxChange(e) {
    const checkArray: FormArray = this.form.get('checkArray') as FormArray;

    if (e.target.checked) {
      checkArray.push(new FormControl(e.target.value));
    } else {
      let i: number = 0;
      checkArray.controls.forEach((item: FormControl) => {
        if (item.value == e.target.value) {
          checkArray.removeAt(i);
          return;
        }
        i++;
      });
    }
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
