import { Component, OnInit, OnDestroy } from '@angular/core';
declare var myExtObject2: any;
@Component({
  selector: 'app-playvs',
  templateUrl: './playvs.component.html',
  styleUrls: ['./playvs.component.css']
})
export class PlayvsComponent implements OnInit {
  title = 'chessAppNg';
  code = 0;
  constructor() { }

  ngOnInit(): void{
    this.add()
    // this.createGame('./assets/img/chesspieces/wikipedia/{piece}.png')
  }

  ngOnDestroy(){
    myExtObject2.delete();
  }
  createGame(s: String,ori: String) {
    console.log("hi")
    myExtObject2.create(s,ori);
  }

  myFunction(){
    console.log("?")
  }

  callFunction2() {
      console.log(myExtObject2.func2());
  }

  delete(){
    myExtObject2.delete();
    
  }

  add(){
    myExtObject2.add();
  }

  getMoves(){
    myExtObject2.getMoves();
    console.log( myExtObject2.getMoves());
  }

  color(x: any){
    myExtObject2.color(x);
  }

  toggle(){
    myExtObject2.toggle();
  }

  generateCode(){
    var val = Math.floor(1000 + Math.random() * 9000);
    this.title = "w";
    this.code = val;
    myExtObject2.makeGame(this.code);
    this.createGame('./assets/img/chesspieces/wikipedia/{piece}.png','white')
    
  }

}
