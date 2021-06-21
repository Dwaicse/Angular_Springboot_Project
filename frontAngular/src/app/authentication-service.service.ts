import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {

  constructor() { }

  verifyUser(username:string, password:string){
    if(username==="user"&&password==="password"){
      return true;
    }
    else {
      return false;
    }
  }
}
