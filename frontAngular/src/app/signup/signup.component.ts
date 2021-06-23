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
  firstName:String=""
  lastName:string =""
  account_no:number=0
  address:string=""
  email:string=""
  date_of_birth:string=""
  mobileNO:string=""

  constructor(private service:DosignupService) { }

  ngOnInit(): void {
  }

  performSignUp(){
    this.user.username=this.username;
    this.user.password=this.password;
    this.user.firstname=this.firstName;
    this.user.lastName=this.lastName;
    this.user.account_no=this.account_no;
    this.user.address=this.address;
    this.user.email=this.email;
    this.user.date_of_birth=this.date_of_birth;
    this.user.mobileNo=this.mobileNO;
    this.service.newAccount(this.user)
    
  }

}
