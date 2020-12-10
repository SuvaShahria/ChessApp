import { Component, AfterViewInit } from '@angular/core';
import * as ChessBoard from 'chessboardjs/www/js/chessboard';
//import  Chess from 'chessboardjs/www/js/chess'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit{
  title = 'chessAppNg';
  board: ChessBoard;
  //game: any;
  
  //$status = $('#status')
  ngAfterViewInit() {
   // this.game = new Chess.Chess()
    
    this.board = ChessBoard('board', {
      draggable: true,
        position: 'start',
        pieceTheme: './assets/img/chesspieces/wikipedia/{piece}.png',
       
         onDragStart: this.onDragStart,
         onDrop: this.onDrop,
         onSnapEnd: this.onSnapEnd
    })

    //console.log(typeof(this.board))
  }

  // logic in main branch of index.html
  public onDragStart (source, piece, position, orientation) :boolean{
    //console.log(this.game.fen())
    return true;
  }

  public onDrop (source, target): String{
    return '';
  }

  public onSnapEnd (): void{

  }
}
