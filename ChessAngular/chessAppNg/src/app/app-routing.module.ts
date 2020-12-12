import { AuthGuard } from './helper/auth.guard';
import { HomeComponent } from './components/home/home.component';
import { PlayComponent } from './components/play/play.component';
import { FindMatchComponent } from './components/find-match/find-match.component';

import { HistoryComponent } from './components/history/history.component';
import { TipsComponent } from './components/tips/tips.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { MainComponent } from './components/main/main.component';

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path: '', component: MainComponent, canActivate: [AuthGuard] }
  ,{path: 'main', component: MainComponent}
  ,{path: 'register', component: RegisterComponent}
  ,{path: 'login', component: LoginComponent}
  ,{path: 'tips', component: TipsComponent}
  ,{path: 'history', component: HistoryComponent}
  ,{path: 'find-match', component: FindMatchComponent}
  ,{path: 'play', component: PlayComponent}
  ,{path: 'home', component: HomeComponent}
  
  ,{path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
