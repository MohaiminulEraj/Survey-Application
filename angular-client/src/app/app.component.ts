import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-root',
  template: `
    <div *ngIf="!authService.isAuthenticated(); else loggedInTemplate">
      <app-login></app-login>
    </div>
    <ng-template #loggedInTemplate>
      <!-- Render other authenticated components here -->
      <p>User is logged in!</p>
    </ng-template>
  `,
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular-client';
  constructor(public authService: AuthService) {}

  ngOnInit() {
    // Check authentication status when the app component initializes
    if (!this.authService.isAuthenticated()) {
      // Optionally, you can redirect to the login page here
    }
  }
}
