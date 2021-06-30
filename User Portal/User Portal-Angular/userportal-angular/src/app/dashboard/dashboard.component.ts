
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  // username:any
  // balance:any
 
 IsUserLoggedIn:any
 accountNumber:any
 lastTransactionDate:any
 transactionList:any

 responseMessage:String = localStorage.getItem("responseMessage");
 username:String = localStorage.getItem("username");
 savingAcc:number;
 primaryAcc:number;
 savingBalanceLocal:number;
 primaryBalanceLocal:number;

 constructor(public authService:AuthService, public userService:UserService,private router: Router) {
   console.log(this.username);
  }

 ngOnInit(): void {

   this.userService.getUser(this.username).subscribe(res=>{
     this.savingAcc = res.savingsAccno;
     this.primaryAcc = res.primaryAccno;
     this.savingBalanceLocal = res.savingsBalance;
     this.primaryBalanceLocal = res.primaryBalance;
     localStorage.setItem("savingAccNo",this.savingAcc.toString());
   });

 }

 displayuserdetails() {
   this.userService.getUser(this.username).subscribe(res=>this.ngOnInit());
 }


//   constructor(private http:HttpClient,private service:UserService) { }

//   ngOnInit(): void {
//     this.username=sessionStorage.getItem('username');
//     this.IsUserLoggedIn=String(sessionStorage.getItem('isUserLoggedIn'));
//     if(this.IsUserLoggedIn==="true"){
//       this.IsUserLoggedIn=true
//     }

// //    this.http.get("http://localhost:8080/accounts/acNumber/"+this.username).subscribe(data=>{
// //      this.accountNumber=data
// //    })
// //    this.http.get("http://localhost:8080/accounts/balance/"+this.username).subscribe(balance=>{
// //      this.balance=balance
// //    })
// //   //  this.http.get("http://localhost:8080/transactions/transaction/"+this.accountNumber).subscribe(data=>{
// //   //   this.lastTransactionDate=data
// //   //  })

// //   this.http.get("http://localhost:8080/transactions/transactions/"+this.accountNumber).subscribe(data=>{
// //       // this.transactionList=JSON.stringify(data)
// //       this.transactionList=data
// //   })
// //  } // console.log(this.transactionList[0])


//       this.username = this.service.getUser()

//   }
}