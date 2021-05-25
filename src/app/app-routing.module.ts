import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './login/admin/admin.component';
import { ForgotComponent } from './login/forgot/forgot.component';
import { SignupComponent } from './login/signup/signup.component';
import { UserComponent } from './login/user/user.component';

const routes: Routes = [
  {path:"user",component:UserComponent},
  {path:"admin",component:AdminComponent},
  {path:"signup",component:SignupComponent},
  {path:"forgot",component:ForgotComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
