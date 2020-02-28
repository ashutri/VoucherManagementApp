import { Component, OnInit } from '@angular/core';
import { Admin } from "../../admin/admin";
import { ConsumerService } from "../consumer.service";
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-consumer',
  templateUrl: './consumer.component.html',
  styleUrls: ['./consumer.component.css'],
  providers: [ConsumerService, HttpClient]
})
export class ConsumerComponent implements OnInit {
  selectedContact;
  mobile:number;
  private admins: Admin[];
  constructor(private router: Router,
    private adminService: ConsumerService) { }
  ngOnInit() {
    this.getVoucher();
  }

  getVoucher() {
    this.adminService.findAll(this.mobile).then(
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
