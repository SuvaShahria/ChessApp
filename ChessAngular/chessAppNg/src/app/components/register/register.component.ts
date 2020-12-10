import { UserService } from './../../services/user.service';
import { ClientMessage } from './../../models/client-message.model';
import { Component, OnInit } from '@angular/core';
import { User } from './../../models/user.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  
  title = 'Register New Player';
  
  // Constructor Injection
  constructor(private userService: UserService) { }

  //For databinding
  public user: User = new User('', '', '', '', '');

  // Message to the user
  public clientMessage: ClientMessage = new ClientMessage('');

  public registerHero(): void {
    this.userService.registerHero(this.user)
      .subscribe(
        data => this.clientMessage = data,
        error => this.clientMessage.message = 'SOMETHING WENT WRONG'
      )
  }
}