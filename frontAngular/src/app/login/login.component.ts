import { Component, OnInit } from '@angular/core';
import { AuthenticationServiceService } from '../authentication-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  message=""
  username:any;
  password:any;
  constructor(private authService:AuthenticationServiceService) { }

  ngOnInit(): void {
  }

  logIn(){
    if(this.authService.verifyUser(this.username,this.password)){
        this.message="login success!!"
    }
  }

}
