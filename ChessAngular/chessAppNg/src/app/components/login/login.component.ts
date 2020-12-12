import { AuthService } from '@services/auth.service';
// import { UserService } from '@services/user.service';
import { ClientMessage } from '@models/client-message.model';
import { Component, OnInit } from '@angular/core';
import { User } from '@models/user.model';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // title = 'Please Login';
  // public clientMessage: ClientMessage = new ClientMessage('');
  // public user: User = new User(0,'','','');
  loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    error = '';
  
    title = 'Hello';

  constructor(
    private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authService: AuthService) 
        {
          if (this.authService.userValue) { 
            this.router.navigate(['/']);
         }
        }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });

    this.returnUrl = this.route.snapshot.queryParamMap['returnUrl'] || '/';
  }

  get f() {return this.loginForm.controls;}

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.loginForm.invalid) {
        return;
    }
    this.loading = true;
        this.authService.login(this.f.username.value, this.f.password.value)
            .pipe(first())
            .subscribe(
                data => {
                    this.router.navigate([this.returnUrl]);
                },
                error => {
                    this.error = error;
                    this.loading = false;
                });
    }

// Login(): void {
//   console.log(this.user);
//     this.userService.Login(this.user)
//       .subscribe(
//         data => this.clientMessage = data,
//         error => this.clientMessage.message = 'SOMETHING WENT WRONG'
//       )
//   }
}

