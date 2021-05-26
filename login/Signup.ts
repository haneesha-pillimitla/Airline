import { EmailValidator } from "@angular/forms";

export class Signup{
    userId : number|undefined;
    title :string|undefined;
    firstname : string |undefined;
    lastname : string |undefined;
    dateOfBirth :Date|undefined;
    phoneNo : number|undefined;
    emailaddr : string|undefined;
    password :string|undefined;
    confirmpassword : string|undefined;
}