package Tic_tac_toe.GameBoard;

import Tic_tac_toe.PalyingPiece.PlayingPiece;

public class GameBoard {
   public int size;
    public PlayingPiece[][] board;
    public GameBoard(int size){
        this.size=size;
        this.board=new PlayingPiece[size][size];
    }


    public void addPiece(int row, int col, PlayingPiece piece){
        board[row][col]=piece;
    }

   
    
}
