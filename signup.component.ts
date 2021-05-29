import { Component, OnInit } from '@angular/core';
import { FlightService } from '../flight.service';
import { Signup } from '../Signup';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  //tempSignup:string|undefined;

  constructor(private sg:FlightService) { }
mysignup:Signup = new Signup();
mysignup1:Signup = new Signup();
str="h@gmail.com";

  ngOnInit(): void {
  }
  addUser(mysignup: Signup){
    if(mysignup.password==mysignup.confirmpassword){
this.sg.addUserService(mysignup).subscribe(data=>{
  console.log(data);
  if(data=="User already exists"){
  alert(data+"!,try with another email or phone-number");
  }
  else{
    alert(data);
    if(mysignup.emailaddr!=null){
      this.str=mysignup.emailaddr;
    }
    //this.str=this.mysignup.emailaddr;
     this.sg.findUserByMailService(this.str).subscribe((data:Signup)=>{
       console.log(data);
       this.mysignup1=data;
     })
  }
  })
}else{
  alert("password and confirmpassword is unmatch")
}
  }

}
function mail(mail: any) {
  throw new Error('Function not implemented.');
}

