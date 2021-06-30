import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  readonly rootUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  loginUser(userName: string, password: string) {

    let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();
    let headers = new HttpHeaders({
      Authorization: basicAuthHeaderString
    })
    var body = {
      username: userName,
      password: password
    }
    return this.http.post(this.rootUrl + '/login', body,{headers});
   
  }


  createBasicAuthenticationHttpHeader(){

    let username = 'user'
    let password = 'password'
    let basicAuthHeaderString = 'Basic '+window.btoa(username + ':' + password)
    return basicAuthHeaderString;

 }
}
