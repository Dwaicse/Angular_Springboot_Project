import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DosignupService } from '../dosignup.service';
import { User } from '../user';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user:User = new User();
  username: string =""
  password:string =""
  firstname:String=""
  lastname:string =""
  address:string=""
  email:string=""
  dateOfBirth:string=""
  phone:string=""
  invalidLogin=true
  errorMessage="Invalid Credentials"
  constructor(private service:DosignupService) { }

  ngOnInit(): void {
  }

  performSignUp(){
    this.user.username=this.username;
    this.user.password=this.password;
    this.user.firstname=this.firstname;
    this.user.lastname=this.lastname;
    this.user.address=this.address;
    this.user.email=this.email;
    this.user.dateOfBirth=this.dateOfBirth;
    this.user.phone=this.phone;
    this.service.newAccount(this.user)
    
  }

}
