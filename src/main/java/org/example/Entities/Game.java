package org.example.Entities;

import org.example.Enum.PlayerMove;
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

    public void play(int rounds) {
        for (int i = 0; i < rounds; i++) {
            PlayerMove player1Move = player1.getPlayerInput();
            PlayerMove player2Move = player2.getPlayerInput();
            // update score of both players
            player1.updateScore(player2Move);
            player2.updateScore(player1Move);
        }
    }
}
