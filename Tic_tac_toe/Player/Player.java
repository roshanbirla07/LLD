package Tic_tac_toe.Player;

import Tic_tac_toe.PalyingPiece.PlayingPiece;

public class Player {
    public String name;
    public PlayingPiece piece;
    public Player(String name, PlayingPiece piece){
        this.name=name;
        this.piece=piece;
    }
}
