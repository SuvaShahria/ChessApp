import { Component, AfterViewInit } from '@angular/core';
import * as ChessBoard from 'chessboardjs/www/js/chessboard';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit{
  title = 'chessAppNg';
  board: ChessBoard;
  
  //$status = $('#status')
  ngAfterViewInit() {
    this.board = ChessBoard('board', {
      draggable: true,
        position: 'start',
        pieceTheme: './assets/img/chesspieces/wikipedia/{piece}.png',
       
         onDragStart: this.onDragStart,
         onDrop: this.onDrop,
         onSnapEnd: this.onSnapEnd
    })
  }

  // logic in main branch of index.html
  public onDragStart (source, piece, position, orientation) :boolean{
    return true;
  }

  public onDrop (source, target): String{
    return '';
  }

  public onSnapEnd (): void{

  }
}
