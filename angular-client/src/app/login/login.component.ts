import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  // create a form named ngForm
  loginForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });


  constructor(private authService: AuthService) {}

  login() {
    // this.authService.login(this.credentials).subscribe(response => {
    //   console.log('Login successful', response);
    // }, error => {
    //   console.error('Login failed', error);
    // });
  }
}
