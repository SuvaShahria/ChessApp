import { Component, AfterViewInit, OnInit } from '@angular/core';
import * as ChessBoard from 'chessboardjs/www/js/chessboard';
import  Chess from 'chess.js';
//declare const Chess:any;
 //const Chess = require('chess.js');
 //import * as Chess from 'chessboardjs/www/js/chess.js'
 
//declare const Chess:any;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  public chess: Chess = new Chess() ;
 
  board: ChessBoard;
   //chess = new Chess();
  ngOnInit(){
    
    //this.game = new Chess.Chess();
    this.board = ChessBoard('board', {
      draggable: true,
        position: 'start',
        pieceTheme: './assets/img/chesspieces/wikipedia/{piece}.png',
        onDragStart: this.onDragStart,
        onDrop: this.onDrop,
        onSnapEnd: this.onSnapEnd
    })
  }
  
  // should return false if not ur turn
  //source -starting position/ piece name/ position/ where to
  public onDragStart (source, piece, position, orientation): boolean{

    //game end
    
    //this.chess.game_over()

     // console.log(this.chess.game_over())
    // only pick up pieces for the side to move
    //console.log(this.chess.turn())
    

    return true;
  }

  //If move legal return empty string. else return string 'snapback'
  public onDrop (source, target): String{
    // var move = this.chess.move({
    //   from: source,
    //   to: target,
    //   promotion: 'q' //promote to queen
    // })
  
    // illegal move
    // if (move === null) return 'snapback'
    return 'snapback'
    //to revert return 'snapback'
  }

  public onSnapEnd (){
   // this.board.position(this.game.fen())
  }

  
  
}