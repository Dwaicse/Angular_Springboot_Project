import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{ FormsModule, NgModel } from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {EnableService} from './enable.service';
import {DisableService} from './disable.service';
import {HttpIntercepterService} from './service/http/http-intercepter.service';
import { UserAccountComponent } from './user-account/user-account.component';
import { CheckbookRequestsComponent } from './checkbook-requests/checkbook-requests.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthorizeRegistrationComponent } from './authorize-registration/authorize-registration.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

import { from } from 'rxjs';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserAccountComponent,
    CheckbookRequestsComponent,
    AuthorizeRegistrationComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    Ng2SearchPipeModule
  ],
  providers: [EnableService,DisableService,
  {provide:HTTP_INTERCEPTORS, useClass:HttpIntercepterService,multi:true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
