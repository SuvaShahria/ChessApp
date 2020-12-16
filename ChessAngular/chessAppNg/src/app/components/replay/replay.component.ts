import { Component, OnInit, OnDestroy } from '@angular/core';
declare var myExtObject3: any;
@Component({
  selector: 'app-replay',
  templateUrl: './replay.component.html',
  styleUrls: ['./replay.component.css']
})
export class ReplayComponent implements OnInit, OnDestroy{
  title = 'chessAppNg';
  ngOnInit(): void{
    // this.add()
    // this.createGame('./assets/img/chesspieces/wikipedia/{piece}.png')
  }

  ngOnDestroy(){
    // myExtObject3.delete();
  }
  createGame(s: String) {
    console.log("hi")
    myExtObject3.create(s);
  }

  myFunction(){
    console.log("?")
  }

  callFunction2() {
      console.log(myExtObject3.func2());
  }

  delete(){
    myExtObject3.delete();
    
  }

  add(){
    myExtObject3.add();
  }

  getMoves(){
    myExtObject3.getMoves();
    console.log( myExtObject3.getMoves());
  }

  color(x: any){
    myExtObject3.color(x);
  }

  toggle(){
    myExtObject3.toggle();
  }

}
