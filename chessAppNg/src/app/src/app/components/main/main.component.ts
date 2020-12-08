import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  
    title = 'Super Hero Portal';
    image = 'assets/images/superhero.jpg'

  constructor() { }

  ngOnInit(): void {
  }
}
