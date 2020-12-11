import { Component, OnInit, OnDestroy } from '@angular/core';
declare var myExtObject: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy{
  title = 'chessAppNg';
  ngOnInit(): void{
    this.createGame()
  }

  ngOnDestroy(){
    
  }
  createGame() {
    console.log("hi")
    myExtObject.create();
  }

  

  callFunction2() {
      console.log(myExtObject.func2());
  }

  delete(){
    myExtObject.delete();
    
  }

  add(){
    myExtObject.add();
  }
}
