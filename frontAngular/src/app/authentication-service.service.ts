import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {
  
  constructor(private http:HttpClient) { }

  verifyUser():Observable<object>{
    //access httpCLient
    return this.http.get("http://localhost:8080/login")
    
  }
}
