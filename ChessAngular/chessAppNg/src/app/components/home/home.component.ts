import { AuthService } from './../../services/auth.service';
import { User } from '@app/models/user.model';
import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { BehaviorSubject, Observable } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  loading = false;
  users: User[];

  private userSubject: BehaviorSubject<User>;
  public user: Observable<User>;

  constructor(private authService: AuthService) { 
    this.userSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('user')));  
    this.user = this.userSubject.asObservable();
    console.log(this.userValue);
  }
  public get userValue(): User {
    return this.userSubject.value;
  }
  
  ngOnInit(): void {

  }

}
