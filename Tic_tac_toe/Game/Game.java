package Tic_tac_toe.Game;

import java.util.*;

import Tic_tac_toe.GameBoard.GameBoard;
import Tic_tac_toe.PalyingPiece.PlayingPieceX;
import Tic_tac_toe.PalyingPiece.PlayingPieceType;
import Tic_tac_toe.PalyingPiece.PlayingPieceO;
import Tic_tac_toe.Player.Player;

public class Game {
    GameBoard board;
    Player[] players;
    int PlayerTurn;
    Scanner scanner;
   
    public void initializeGame(int size){
        board=new GameBoard(size);
        players=new Player[2];
        players[0]=new Player("Player 1", new PlayingPieceX(PlayingPieceType.X));
        players[1]=new Player("Player 2", new PlayingPieceO(PlayingPieceType.O));
        PlayerTurn=0;
        scanner=new Scanner(System.in);
    }

    public void startGame(){

        while(true){


            printBoard(board);
            if(!isEmptyCells(board)){
                System.out.println("Game is a draw");
                break;
            }
            
            makeMove(board, players[PlayerTurn]);

           

            if(isWinner(board, players[PlayerTurn])){
                printBoard(board);
                System.out.println(players[PlayerTurn].name + " is the winner");
                break;
            }

            PlayerTurn=1-PlayerTurn;


            
        }

        }
    
    private boolean isWinner(GameBoard board, Player player){
        return checkRow(board, player) || checkColumn(board, player) || checkDiagonal(board, player);
    }

    private boolean checkRow(GameBoard board, Player player){
        
        for(int i=0;i<board.size;i++){
            boolean isRowWin=true;
            for(int j=1;j<board.size;j++){
                if(board.board[i][j]==null || board.board[i][j].type!=player.piece.type){
                    isRowWin=false;
                    break;
                }
            }
            if(isRowWin){
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn(GameBoard board, Player player){

        for(int i=0;i<board.size;i++){
            boolean isColumnWin=true;
            for(int j=1;j<board.size;j++){
                if(board.board[j][i]==null || board.board[j][i].type!=player.piece.type){
                    isColumnWin=false;
                    break;
                }
            }
            if(isColumnWin){
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal(GameBoard board, Player player){

        boolean isDiagonalWin=true;
        for(int i=0;i<board.size;i++){
            if(board.board[i][i]==null || board.board[i][i].type!=player.piece.type){
                isDiagonalWin=false;
                break;
            }
        }
        if(isDiagonalWin){
            return true;
        }
        isDiagonalWin=true;
        for(int i=0;i<board.size;i++){
            if(board.board[i][board.size-i-1]==null || board.board[i][board.size-i-1].type!=player.piece.type){
                isDiagonalWin=false;
                break;  
            }
        }
        return isDiagonalWin;
    }


    private void makeMove(GameBoard board, Player player){
        System.out.println(player.name + " make your move");
        int row, col;
        System.out.println("Enter the row and column");
        row=scanner.nextInt();  
        col=scanner.nextInt();
        board.addPiece(row, col, player.piece);
        
    }

    private boolean isEmptyCells(GameBoard board){
        for(int i=0;i<board.size;i++){
            for(int j=0;j<board.size;j++){
                if(board.board[i][j]==null){
                    return true;
                }
            }
        }
        return false;
    }

    private void printBoard(GameBoard board){
        for(int i=0;i<board.size;i++){
            for(int j=0;j<board.size;j++){
                if(board.board[i][j] != null) {
                    System.out.print(board.board[i][j].type + " ");
                } else {
                    System.out.print("  ");  
                }
                if(j<board.size-1){
                    System.out.print("|");
                }
            }
            if(i<board.size-1){
                System.out.println();
                System.out.println("---------");
            }
            System.out.println();
        }
    }
    
}
