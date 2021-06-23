import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginserviceService } from '../loginservice.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  invalidLogin:boolean=false
  username=""
  password=""
  // message="login failure"
  errorMessage="Invalid Credentials"
  validUser:any
  constructor(private service:LoginserviceService,private router:Router) { }

  ngOnInit(): void {
  }

  logIn(){
      this.service.performLogin(this.username,this.password).subscribe(data=>{
        if(data){
          // this.message="login success!!"
          this.invalidLogin=false
          this.router.navigate(['dashboard'])
        }
        else{
              // this.message="login failure"
              this.invalidLogin=true
        }
      })
     
      
      
  }
//   goToSignUp(){
//     window.open("http://localhost:4200/signup", "_blank");
// }

}
