import { Game } from './../../models/game.model';
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


  users: User[];
  games: Game[];
  players: User[];
  
  private userSubject: BehaviorSubject<User>;
  public user: Observable<User>;
  public game: Observable<Game>;
  public player: Observable<User>;

  constructor(private userService: UserService) { 
    this.userSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('user')));  
    this.user = this.userSubject.asObservable();
    console.log(this.userValue);
  }

  ngOnInit(): void {
    this.getAllUsers();
    this.getAllPendingGames();
  }

  public get userValue(): User {
    return this.userSubject.value;
  }
  
  getAllUsers(): void {
    this.userService.findAllUsers()
      .subscribe(users => this.users = users);
  }

  getAllPendingGames(): void {
    this.userService.findAllPendingGames()
      .subscribe(games => this.games = games);
  }

  // getAllGamesWithPlayer(name: string): void {
  //   name = name.trim();
  //   if (!name) {return;}
  //   this.userService.findAllGamesWithPlayer({name} as User)
  //   .subscribe(player => {
  //     this.player;
  //   })
  // }





}
