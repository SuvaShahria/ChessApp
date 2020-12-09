import { Component, AfterViewInit } from '@angular/core';
import * as ChessBoard from 'chessboardjs/www/js/chessboard';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements AfterViewInit {

  title = 'frontend';
  board1: ChessBoard;
  ngOnInit(){
    this.board1 = ChessBoard('board1', 'start')
  }
  ngAfterViewInit() {
    
    

}
}