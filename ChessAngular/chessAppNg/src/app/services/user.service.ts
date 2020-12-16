import { USER_URL } from './../../environments/environment.prod';
import { ClientMessage } from './../models/client-message.model';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  httpOptions = {
    headers: new HttpHeaders ({'Content-Type': 'application/json'})
  }

  constructor(private http: HttpClient) { }

  public registerUser(user: User): Observable<ClientMessage> {
    return this.http
      .post(`${USER_URL}registerUser`, user, this.httpOptions)
      .pipe(
        catchError(this.handleError<any>('cannot register user'))
      )
  }

  public findUser(user: User): Observable<User> {
    return this.http
      .post<User>(`${USER_URL}findUser`, user)
      .pipe(
        catchError(this.handleError<User>('get user', null))
      )
  }

  public findAllUsers(): Observable<User[]> {
    return this.http
    .get<User[]>(`${USER_URL}getAllUsers`)
    .pipe(
      catchError(this.handleError<User[]>('getUsers', []))
      );
    }

    public findAllPendingGames(): Observable<User[]> {
      return this.http
      .get<User[]>(`${USER_URL}getAllPendingGames`)
      .pipe(
        catchError(this.handleError<User[]>('getUsers', []))
        );
      }

      public findAllGamesWithPlayer(): Observable<User[]> {
        return this.http
        .get<User[]>(`${USER_URL}getAllGamesWithPlayer`)
        .pipe(
          catchError(this.handleError<User[]>('getUsers', []))
          );
        }

  private handleError<T>(operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {
  
        // TODO: send the error to remote logging infrastructure
        console.error(error); // log to console instead

        // Let the app keep running by returning an empty result.
        return of(result as T);
      };
    }
  
}
