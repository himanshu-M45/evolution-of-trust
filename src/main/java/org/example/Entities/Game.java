package org.example.Entities;

import org.example.Exceptions.CannotInitialteGameWihoutPlayers;

public class Game {
    private final Player player1;
    private final Player player2;

    public Game(Player player1, Player player2) {
        if (player1 == null || player2 == null) {
            throw new CannotInitialteGameWihoutPlayers("Player not set");
        }
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        int player1Move = player1.getPlayerInput();
        int player2Move = player2.getPlayerInput();

        // update scores according to input
        if (player1Move == 1 && player2Move == 1) { // both players cooperate
            player1.updateScore(2);
            player2.updateScore(2);
        }
        if (player1Move == 0 && player2Move == 1 ) { // player1 cheats, player2 cooperates
            player1.updateScore(3);
            player2.updateScore(-1);
        }
        if (player1Move == 1 && player2Move == 0) { // player1 cooperates, player2 cheats
            player1.updateScore(-1);
            player2.updateScore(3);
        }
    }
}
