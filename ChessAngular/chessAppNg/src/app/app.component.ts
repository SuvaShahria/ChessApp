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
    this.add()
    this.createGame('./assets/img/chesspieces/wikipedia/{piece}.png')
  }

  ngOnDestroy(){
    myExtObject.delete();
  }
  createGame(s: String) {
    console.log("hi")
    myExtObject.create(s);
  }

  myFunction(){
    console.log("?")
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

  getMoves(){
    myExtObject.getMoves();
    console.log( myExtObject.getMoves());
  }

  color(x: any){
    myExtObject.color(x);
  }

}
