import { Injectable } from '@angular/core';
import { Admin } from "../admin/admin";
import { Consumer } from "../consumer/consumer";
import { Http, Response } from "@angular/http";
import { Headers, RequestOptions } from '@angular/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConsumerService {
  private apiUrl = '/api/consumer';
  private vouchers: Admin[];
  constructor(private http: HttpClient, private https:Http) {
  }

  findAll(mobile:number): Promise<Array<any>> {
    return this.https.get(this.apiUrl+"/consumerList/"+mobile)
    .toPromise()
    .then(response => response.json() as Admin[])
    .catch(this.handleError);
    }

    create(con:Consumer): Promise<Array<Admin>> {
      let genHeaders = new Headers({ 'Content-Type': 'application/json' });
      return this.https.post(this.apiUrl+"/addNumber", con, { headers: genHeaders })
      .toPromise()
      .then((res) => this.findAll(con.mobile))
      .catch(this.handleError);
      }
    private handleError(error: any): Promise<Array<any>> {
      console.error('An error occurred', error);
      return Promise.reject(error.message || error);
      }
}
