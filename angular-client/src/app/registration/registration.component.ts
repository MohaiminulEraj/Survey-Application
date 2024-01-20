import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  standalone: true,
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
  imports: [ReactiveFormsModule]
})
export class RegistrationComponent {

  registerForm = new FormGroup({
    name: new FormControl(''),
    address: new FormControl(''),
    email: new FormControl(''),
    mobile: new FormControl(''),
    password: new FormControl('')
  });

  constructor(private authService: AuthService) {}

  register() {
    // this.authService.register(this.user).subscribe(response => {
    //   console.log('Registration successful', response);
    // }, error => {
    //   console.error('Registration failed', error);
    // });
  }
}
