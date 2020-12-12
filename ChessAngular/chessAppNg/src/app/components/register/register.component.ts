import { UserService } from '@services/user.service';
import { ClientMessage } from '@models/client-message.model';
import { Component, OnInit } from '@angular/core';
import { User } from '@models/user.model';

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
  public user: User = new User(0, '', '', '','','');

  // Message to the user
  public clientMessage: ClientMessage = new ClientMessage('');

  public registerUser(): void {
    console.log(this.user);
    this.userService.registerUser(this.user)
      .subscribe(
        data => this.clientMessage = data,
        error => this.clientMessage.message = 'SOMETHING WENT WRONG'
      )
  }
}