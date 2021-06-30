import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class WithdrawService {
  readonly rooturl='http://localhost:8080';
  constructor(private http:HttpClient) { 

  }

  insertEntry(saccount:string,amount:number){
    let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();
    let headers = new HttpHeaders({
      Authorization: basicAuthHeaderString
    })
    var body = {
      saccountNo: saccount,
      amount: amount

    }

    console.log(body);
    return this.http.post(this.rooturl + '/account/withdraw/',body,{headers});
  }

  createBasicAuthenticationHttpHeader(){

    let username = 'user'
    let password = 'password'
    let basicAuthHeaderString = 'Basic '+window.btoa(username + ':' + password)
    return basicAuthHeaderString;

 }
}
