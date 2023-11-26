import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, AbstractControl } from '@angular/forms';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
    constructor(private loginService: LoginService) { }

  ngOnInit(): void {
    this.buildLoginForm();
  }

  buildLoginForm(): void {
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required])
    })
  }

  public getCtr(controlName: string): AbstractControl {
    return this.loginForm.controls[controlName];
  }

  onLogin() {
    if (this.loginForm.valid) {
      this.loginService.login(this.loginForm.value).subscribe( res => {
        console.log(res);
      });
    }
  }

}
