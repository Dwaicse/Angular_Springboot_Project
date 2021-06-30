import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TransferService {

    readonly rootUrl = 'http://localhost:8080';
  
    constructor(private http: HttpClient) { }
  
    insertEntry(username:string, saccount:string,ifscNo:string,raccount:string,amount:number) {
      let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();
    let headers = new HttpHeaders({
      Authorization: basicAuthHeaderString
    })
      var body = {
        username:username,
        saccount: saccount,
        ifsc: ifscNo, 
        raccount:raccount,
        amount:amount
      }
      console.log(body);
      return this.http.post(this.rootUrl + '/account/transfer', body,{headers});
    }

    createBasicAuthenticationHttpHeader(){

      let username = 'user'
      let password = 'password'
      let basicAuthHeaderString = 'Basic '+window.btoa(username + ':' + password)
      return basicAuthHeaderString;
  
   }
  }
  