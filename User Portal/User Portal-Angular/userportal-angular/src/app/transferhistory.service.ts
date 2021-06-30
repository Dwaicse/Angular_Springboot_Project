import { Injectable } from '@angular/core';
import {TransferHistory} from './_models/transferhistory';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransferhistoryService {

  private url:String;

  constructor(private http:HttpClient) {
    this.url="http://localhost:8080"
   }
   public getTransferHistory(accNo):Observable<TransferHistory[]>{
    let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();
    let headers = new HttpHeaders({
      Authorization: basicAuthHeaderString
    })
    return this.http.get<TransferHistory[]>(this.url+"/account/getTransfers/"+accNo,{headers});
  }
  // public getSavingAccount(username):Observable<SavingAccount>{
  //   return this.http.get<SavingAccount>(this.url+"/account/getsaving/"+username);
  // }

  createBasicAuthenticationHttpHeader(){

    let username = 'user'
    let password = 'password'
    let basicAuthHeaderString = 'Basic '+window.btoa(username + ':' + password)
    return basicAuthHeaderString;

 }
}
