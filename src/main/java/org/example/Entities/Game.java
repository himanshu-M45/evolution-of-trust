package org.example.Entities;

import org.example.Exceptions.CannotInitialteGameWihoutPlayers;

public class Game {
    private final Player firstPlayer;
    private final Player secondPlayer;

    public Game(Player firstPlayer, Player secondPlayer) {
        if (firstPlayer == null || secondPlayer == null) {
            throw new CannotInitialteGameWihoutPlayers("Player not set");
        }
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play(int rounds) {
        for (int i = 0; i < rounds; i++) {
            firstPlayer.playWith(secondPlayer);
        }
    }
}
