import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppComponent } from './app.component';
import { BrowserModule } from '@angular/platform-browser';
import {  routes } from './app.routes';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [AppComponent,
    LoginComponent,
    RegistrationComponent],
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes), // Configure routes using forRoot
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
