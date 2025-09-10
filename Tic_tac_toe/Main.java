package Tic_tac_toe;

import Tic_tac_toe.Game.Game;

public class Main {
   

    public static void main(String[] args) {
        Game game;
        game=new Game();
        game.initializeGame(3);
        game.startGame();
    }

}
