import { LoginComponent } from './src/app/components/login/login.component';
import { RegisterComponent } from './src/app/components/register/register.component';
import { MainComponent } from './src/app/components/main/main.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path: '', redirectTo: 'main', pathMatch: 'full'}
  ,{path: 'main', component: MainComponent}
  ,{path: 'register', component: RegisterComponent}
  ,{path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
