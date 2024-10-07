package org.example.Entities;

import org.example.Strategy.PlayerStrategy;

public class Player {
    public int score;
    private final PlayerStrategy strategy;

    public Player(PlayerStrategy strategy) {
        this.score = 0;
        this.strategy = strategy;
    }
}
