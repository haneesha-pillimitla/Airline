import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserComponent } from './user/user.component';
import { AppRoutingModule } from '../app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { AdminComponent } from './admin/admin.component';
import { SignupComponent } from './signup/signup.component';
import { ForgotComponent } from './forgot/forgot.component';



@NgModule({
  declarations: [
    UserComponent,
    AdminComponent,
    SignupComponent,
    ForgotComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    BrowserModule
  ]
})
export class LoginModule { }
