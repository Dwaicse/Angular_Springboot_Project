import { Component, OnInit } from '@angular/core';
import { AuthenticationServiceService } from '../authentication-service.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  user:any
  errorMessage="Invalid Credentials"
  username=""
  password=""
  invalidLogin:boolean=false;
  message=""
  constructor(private authService:AuthenticationServiceService) { }

  ngOnInit(): void {
  }

  logIn(){
    this.authService.verifyUser().subscribe(data=>{
      this.user=data;
    })
      if(!(this.user.username===this.username && this.user.password===this.password))  {
        this.invalidLogin=true;
        this.message=""

      }
      else{
        this.message="successful login!!!"
        this.invalidLogin=false
        //from here the page should be redirected to dashboard location
      }
    
  }

}
