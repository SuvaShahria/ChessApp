var myExtObject = (function() {
  var t = 0;

  return {
    create: function() {
      // ---------------------------------------------------------------------------------------------------
      
    // document.getElementById('board').style.visibility = 'visible';
    var board = null;
    var game = new Chess()
    var $status = $('#status')

    function onDragStart (source, piece, position, orientation) {
      //game end
      if (game.game_over()) return false
    
      // only pick up pieces for the side to move
      if ((game.turn() === 'w' && piece.search(/^b/) !== -1) ||
          (game.turn() === 'b' && piece.search(/^w/) !== -1)) {
        return false
      }
    }
    
    function onDrop (source, target) {
     
      // see if the move is legal
      var move = game.move({
        from: source,
        to: target,
        promotion: 'q' //promote to queen
      })
    
      // illegal move
      if(move != null) t = t+1
      if (move === null) return 'snapback'
    
      updateStatus()
    }
    
    // update the board position after the piece snap
    function onSnapEnd () {
      board.position(game.fen())
    }
    
    function updateStatus () {
      var status = ''
    
      var moveColor = 'White'
      if (game.turn() === 'b') {
        moveColor = 'Black'
      }
    
      // checkmate
      if (game.in_checkmate()) {
        status = 'Game over, ' + moveColor + ' is in checkmate.'
      }
    
      // draw?
      else if (game.in_draw()) {
        status = 'Game over, drawn position'
      }
    
      
      else {
        status = moveColor + ' turn'
    
        
        if (game.in_check()) {
          status += ', ' + moveColor + ' is in check'
        }
      }
    
      $status.html(status)
      
    }
    board = ChessBoard('board', {
    draggable: true,
      position: 'start',
      pieceTheme: './assets/img/chesspieces/wikipedia/{piece}.png',
      onDragStart: onDragStart,
      onDrop: onDrop,
      onSnapEnd: onSnapEnd
  })

  updateStatus()






      //-------------------------------------------------CREATE------------------------------------------------------------------------
    },
    func2: function() {
      return t;
    },
    delete: function(){
      var b = document.getElementById("board");
      b.remove()
      var b1 = document.getElementById("st");
      b1.remove()
      var b2 = document.getElementById("status");
      b2.remove()
    },
    add: function(){
      c = document.createElement('div');
      c.setAttribute("id", "board");
      document.body.appendChild(c);
      c = document.createElement('Label');
      c.setAttribute("id", "st");
      c.innerHTML= "STATUS:"
      document.body.appendChild(c);
      c = document.createElement('div');
      c.setAttribute("id", "status");
      document.body.appendChild(c);
    }
  }

})(myExtObject||{})