import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthorizeUser } from './model/authorizeUser';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService {

  readonly rootUrl = 'http://localhost:8084/user';

  constructor(private http: HttpClient) { }
  
  getRequestData(){
    // let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();
    // let headers = new HttpHeaders({
    //   Authorization: basicAuthHeaderString
    // })
    return this.http.get<AuthorizeUser[]>(this.rootUrl + '/unauthorized/all');
  }
  
  authorizeAccount(username){
    // let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();
    // let headers = new HttpHeaders({
    //   Authorization: basicAuthHeaderString
    // })
    return this.http.get(this.rootUrl + '/'+username + '/authorize');
  }
   
  rejectRequest(username){
    // let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();
    // let headers = new HttpHeaders({
    //   Authorization: basicAuthHeaderString
    // })
    return this.http.get(this.rootUrl +'/'+ username + '/authorize/cancel' );
  
  }

  createBasicAuthenticationHttpHeader(){

    let username = 'user'
    let password = 'password'
    let basicAuthHeaderString = 'Basic '+window.btoa(username + ':' + password)
    return basicAuthHeaderString;

 }


}