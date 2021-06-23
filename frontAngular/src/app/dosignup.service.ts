import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class DosignupService {

  constructor(private http:HttpClient) { }

  newAccount(user:User){
      this.http.post("http://localhost:8080/accounts/newAccount",user).toPromise().then(data=>{
        console.log(data)
      }).catch(err=>{console.log(err)})
  }
}
