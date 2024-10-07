package org.example.Entities;

import org.example.Exceptions.CannotCreatePlayerWithoutStrategy;
import org.example.Strategy.PlayerStrategy;

public class Player {
    private int score;
    private final PlayerStrategy strategy;

    public Player(PlayerStrategy strategy) {
        if (strategy == null) {
            throw new CannotCreatePlayerWithoutStrategy("Strategy not set");
        }
        this.score = 0;
        this.strategy = strategy;
    }

    public int getPlayerInput() {
        return strategy.getMove();
    }

    public void updateScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }
}
