import { Component, OnInit } from '@angular/core';
import { TransferService } from '../transfer.service';

@Component({
  selector: 'app-amount',
  templateUrl: './amount.component.html',
  styleUrls: ['./amount.component.css']
})
export class AmountComponent implements OnInit {

  to:string=""
  from:string=""
  amount:string=""
  constructor(private transferservice:TransferService) { }


  ngOnInit(): void {
  }

  performTransfer(){
      this.transferservice.transfer(this.from,this.to,this.amount)
      console.log("working")
  }

}
