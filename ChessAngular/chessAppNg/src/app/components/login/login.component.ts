import { UserService } from './../../services/user.service';
import { ClientMessage } from './../../models/client-message.model';
import { Component, OnInit } from '@angular/core';
import { User } from './../../models/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  title = 'Please Login';
  public clientMessage: ClientMessage = new ClientMessage('');
  public user: User = new User('','','','','');
  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }
Login(): void {
  console.log(this.user);
    this.userService.Login(this.user)
      .subscribe(
        data => this.clientMessage = data,
        error => this.clientMessage.message = 'SOMETHING WENT WRONG'
      )
  }
}

