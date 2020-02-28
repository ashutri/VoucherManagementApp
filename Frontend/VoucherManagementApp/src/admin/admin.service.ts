import { Injectable } from '@angular/core';
import { Admin } from "./admin";
import { Http, Response } from "@angular/http";
import { Headers, RequestOptions } from '@angular/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable()
export class AdminService {

  private apiUrl = '/api/admin';
  private vouchers: Admin[];
  constructor(private http: HttpClient, private https:Http) {
  }

  findAll(): Promise<Array<any>> {
    return this.https.get(this.apiUrl+"/voucherList")
    .toPromise()
    .then(response => response.json() as Admin[])
    .catch(this.handleError);
    }

    create(num: number): Promise<Array<Admin>> {
      let genHeaders = new Headers({ 'Content-Type': 'application/json' });
      return this.https.post(this.apiUrl+"/create/getVoucher", num, { headers: genHeaders })
      .toPromise()
      .then((res) => this.findAll())
      .catch(this.handleError);
      }

    private handleError(error: any): Promise<Array<any>> {
      console.error('An error occurred', error);
      return Promise.reject(error.message || error);
      }
}
