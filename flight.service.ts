
import { flight } from './flight';
import { Observable } from 'rxjs';
import { Signup } from './Signup';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root'
})
export class FlightService {

  constructor( private myHttp: HttpClient) { }
 
  
 findFlightsBySrcAndDestService(src: string,dest:string,date:string): Observable<flight[]>{
  alert("Service is called");
  return this.myHttp.get<flight[]>("http://localhost:8080/getAllFlights/"+src+","+dest+","+date);

}
findUserService(uId:number):Observable<Signup>{
  alert("Service is called");
  return this.myHttp.get<Signup>("http://localhost:8080/getUser/"+uId);
  //{responseType:'text'}
}
addUserService(signup: Signup):Observable<any>{
  alert("Service is called");
  return this.myHttp.post("http://localhost:8080/addUser",signup,{responseType:'text'});
}
findUserByMailService(mail1: string):Observable<Signup>{
  alert("Service is called");
  return this.myHttp.get<Signup>("http://localhost:8080/getUserDetailsByMail/"+mail1);
}
findUserByNumberService(pno: number):Observable<Signup>{
  alert("Service is called");
  return this.myHttp.get<Signup>("http://localhost:8080/getUserDetailsByNumber/"+pno);

}
}