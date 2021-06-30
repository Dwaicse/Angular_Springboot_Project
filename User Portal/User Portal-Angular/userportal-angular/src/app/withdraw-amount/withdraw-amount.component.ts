
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators, } from '@angular/forms';
import { Router } from '@angular/router';
import { TransferService } from '../transfer.service';
import Swal from 'sweetalert2';
import { HttpClient } from '@angular/common/http';
import {WithdrawService} from '../withdraw.service';

@Component({
  selector: 'app-withdraw-amount',
  templateUrl: './withdraw-amount.component.html',
  styleUrls: ['./withdraw-amount.component.css']
})
export class WithdrawAmountComponent implements OnInit {

  constructor( private formBuilder: FormBuilder,
    private router: Router,
    private transferService: TransferService,private http:HttpClient,private service:WithdrawService) { }
  transferForm: FormGroup;
  loading = false;
  submitted = false;
  response:any

  ngOnInit(): void {
    var username:String=localStorage.getItem("username");
    var accNo=+localStorage.getItem("savingAccNo");
    console.log(accNo)
    console.log(username)
    this.transferForm = this.formBuilder.group({
       
       saccountNo: accNo,
    
       amount:['',[Validators.required]]
   
   });
  }
  get fval() {
    return this.transferForm.controls;
  }

  get saccountno() : any {
      return localStorage.getItem('savingAccNo');
  }

  withdraw(){
      this.submitted=true;
      if(this.transferForm.invalid){
        return;
      }
      this.loading=true;
      const result:any = Object.assign({},this.transferForm.value);
      try{
        this.service.insertEntry(result.saccount,result.amount).subscribe((data:any)=>{
              this.loading=false;
              if(data.transferStatus==true){
                Swal.fire({
                  icon:'success',
                  title:'Successfully Withdrawn',
                  text:data.responseMessage
                })
              }
              else{
                Swal.fire({
                  icon: 'error',
                  title:'Oops...',
                  text:data.responseMessage
                })
              }
        }
        );
      }catch{
        this.loading=false;
      }
  
}
}
