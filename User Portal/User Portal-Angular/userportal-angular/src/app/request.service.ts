import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import {ChequebookResponse} from './_models/chequebookresponse'

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  readonly rootUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  insertRequest(accNo: number,pages:number=20) {

    let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();
    let headers = new HttpHeaders({
      Authorization: basicAuthHeaderString
    })
    var body = {
      account: accNo,
      no_of_pages: pages, 
    }
    console.log(body);
    return this.http.post<ChequebookResponse>(this.rootUrl + '/cheque/request', body,{headers});
  }

  createBasicAuthenticationHttpHeader(){

    let username = 'user'
    let password = 'password'
    let basicAuthHeaderString = 'Basic '+window.btoa(username + ':' + password)
    return basicAuthHeaderString;

 }








}
