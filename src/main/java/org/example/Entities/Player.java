package org.example.Entities;

import org.example.Enum.Move;
import org.example.Exceptions.CannotCreatePlayerWithoutStrategy;
import org.example.Strategy.PlayerStrategy;

public class Player implements Cloneable {
    private int score;
    private PlayerStrategy playerStrategy;

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

    @Override
    public Player clone() {
        try {
            Player cloned = (Player) super.clone();
            cloned.score = 0; // Reset the score
            cloned.playerStrategy = this.playerStrategy.clone(); // Assuming PlayerStrategy has a clone method
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
