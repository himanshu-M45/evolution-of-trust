package org.example.Entities;

import org.example.Enum.Move;
import org.example.Exceptions.CannotCreatePlayerWithoutStrategy;
import org.example.Strategy.PlayerStrategy;

public class Player {
    private int score;
    private final PlayerStrategy playerStrategy;

    public Player(PlayerStrategy playerStrategy) {
        if (playerStrategy == null) {
            throw new CannotCreatePlayerWithoutStrategy("Strategy not set");
        }
        this.score = 0;
        this.playerStrategy = playerStrategy;
    }

    private void profit() {
        this.score += 3;
    }

    private void loss() {
        this.score--;
    }

    public void playWith(Player anotherPlayer) {
        Move myMove = this.nextMove();
        Move opponentMove = anotherPlayer.nextMove();
        if (myMove == Move.COOPERATE) {
            this.loss();
            anotherPlayer.profit();
        }
        if (opponentMove == Move.COOPERATE) {
            this.profit();
            anotherPlayer.loss();
        }

        // update player's move
        this.playerStrategy.processOpponentMove(opponentMove);
        anotherPlayer.playerStrategy.processOpponentMove(myMove);
    }

    private Move nextMove() {
        return playerStrategy.nextMove();
    }

    public int getScore() {
        return score;
    }

    public PlayerStrategy getStrategy() {
        return playerStrategy;
    }

    public void resetScore() {
        this.score = 0;
    }
}
