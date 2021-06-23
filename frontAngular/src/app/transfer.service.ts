import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TransferService {

  constructor(private http: HttpClient) { }

  transfer(from:string,to:string,amount:string){
      this.http.get("http://localhost:8080/transactions/"+from+"/"+to+"/"+amount).subscribe(data=>{
        console.log(data)
      });
      
    }
}
