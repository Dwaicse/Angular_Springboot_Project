import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Transaction } from './_models/transaction'
import { SavingAccount } from './_models/savingaccount'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private url:String;
  

  constructor(private http:HttpClient) {
    this.url="http://localhost:8080"
   }
   public getTransactions(accNo):Observable<Transaction[]>{
    let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();
    let headers = new HttpHeaders({
      Authorization: basicAuthHeaderString
    })
    return this.http.get<Transaction[]>(this.url+"/account/getHistory/"+accNo,{headers});
  }
  public getSavingAccount(username):Observable<SavingAccount>{
    let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();
    let headers = new HttpHeaders({
      Authorization: basicAuthHeaderString
    })
    return this.http.get<SavingAccount>(this.url+"/account/getsaving/"+username,{headers});
  }

  createBasicAuthenticationHttpHeader(){

    let username = 'user'
    let password = 'password'
    let basicAuthHeaderString = 'Basic '+window.btoa(username + ':' + password)
    return basicAuthHeaderString;

 }
  
}
