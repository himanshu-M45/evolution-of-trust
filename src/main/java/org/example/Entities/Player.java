package org.example.Entities;

import org.example.Enum.PlayerMove;
import org.example.Exceptions.CannotCreatePlayerWithoutStrategy;

public class Player {
    private int score;
    private final PlayerMove playerMove;

    public Player(PlayerMove playerMove) {
        if (playerMove == null) {
            throw new CannotCreatePlayerWithoutStrategy("Strategy not set");
        }
        this.score = 0;
        this.playerMove = playerMove;
    }

    public PlayerMove getPlayerInput() {
        return playerMove;
    }

    public void updateScore(PlayerMove opponentMove) {
        if (this.playerMove == PlayerMove.ALWAYS_COOPERATE && opponentMove == PlayerMove.ALWAYS_COOPERATE) { // if both player have cooperated
            this.score += 2;
        }
        if (this.playerMove == PlayerMove.ALWAYS_CHEAT && opponentMove == PlayerMove.ALWAYS_COOPERATE) {
            this.score += 3;
        }
        if (this.playerMove == PlayerMove.ALWAYS_COOPERATE && opponentMove == PlayerMove.ALWAYS_CHEAT) {
            this.score -= 1;
        }
    }

    public int getScore() {
        return score;
    }
}
