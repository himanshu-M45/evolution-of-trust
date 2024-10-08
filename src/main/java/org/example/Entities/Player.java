package org.example.Entities;

import org.example.Enum.Move;
import org.example.Enum.PlayerType;
import org.example.Exceptions.CannotCreatePlayerWithoutStrategy;

public class Player {
    private int score;
    private final PlayerType playerType;

    public Player(PlayerType playerType) {
        if (playerType == null) {
            throw new CannotCreatePlayerWithoutStrategy("Strategy not set");
        }
        this.score = 0;
        this.playerType = playerType;
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

        // update COPYCAT player's move
        if (this.playerType == PlayerType.COPYCAT || anotherPlayer.playerType == PlayerType.COPYCAT) {
            updateMove(anotherPlayer);
        }
    }

    private void updateMove(Player anotherPlayer) {
        if (this.playerType == PlayerType.COPYCAT) {
            this.playerType.setMove(anotherPlayer.nextMove());
        }
        if (anotherPlayer.playerType == PlayerType.COPYCAT) {
            anotherPlayer.playerType.setMove(this.nextMove());
        }
    }

    private Move nextMove() {
        return playerType.getMove();
    }

    public int getScore() {
        return score;
    }
}
