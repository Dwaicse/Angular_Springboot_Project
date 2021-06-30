import { Injectable } from '@angular/core';
import { UserDisplay } from './_models/userdisplay';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url:string;

  constructor(private http:HttpClient) {
    this.url="http://localhost:8080"
   }
   public getUser(username):Observable<UserDisplay>{
    let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();
    let headers = new HttpHeaders({
      Authorization: basicAuthHeaderString
    })

    return this.http.get<UserDisplay>(this.url+"/home/"+username,{headers});
  }

  createBasicAuthenticationHttpHeader(){

    let username = 'user'
    let password = 'password'
    let basicAuthHeaderString = 'Basic '+window.btoa(username + ':' + password)
    return basicAuthHeaderString;

 }
}
