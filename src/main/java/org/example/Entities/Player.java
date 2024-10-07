package org.example.Entities;

import org.example.Enum.Move;
import org.example.Enum.PlayerType;
import org.example.Exceptions.CannotCreatePlayerWithoutStrategy;

public class Player {
    private int score;
    private Move move;
    private final PlayerType playerType;

    public Player(PlayerType playerType) {
        if (playerType == null) {
            throw new CannotCreatePlayerWithoutStrategy("Strategy not set");
        }
        this.score = 0;
        this.move = playerType.getMove();
        this.playerType = playerType;
    }

    private void profit() {
        this.score += 3;
    }

    private void loss() {
        this.score--;
    }

    public void playWith(Player anotherPlayer) {
        if (this.move == Move.COOPERATE) {
            this.loss();
            anotherPlayer.profit();
        }
        if (anotherPlayer.getMove() == Move.COOPERATE) {
            this.profit();
            anotherPlayer.loss();
        }

        // update COPYCAT player's move
        if (this.playerType == PlayerType.COPYCAT || anotherPlayer.playerType == PlayerType.COPYCAT) {
            updateCopycatMove(anotherPlayer);
        }
    }

    private void updateCopycatMove(Player anotherPlayer) {
        if (this.playerType == PlayerType.COPYCAT) {
            this.move = anotherPlayer.getMove();
        }
        if (anotherPlayer.playerType == PlayerType.COPYCAT) {
            anotherPlayer.move = this.getMove();
        }
    }

    private Move getMove() {
        return move;
    }

    public int getScore() {
        return score;
    }
}
