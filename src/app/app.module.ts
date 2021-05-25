import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './login/admin/admin.component';
import { ForgotComponent } from './login/forgot/forgot.component';
import { SignupComponent } from './login/signup/signup.component';
import { UserComponent } from './login/user/user.component';
 
@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    AdminComponent,
    SignupComponent,
    ForgotComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
