package org.example.Entities;

import org.example.Enum.Move;
import org.example.Enum.PlayerType;
import org.example.Exceptions.CannotCreatePlayerWithoutStrategy;

public class Player {
    private int score;
    private final Move move;

    public Player(PlayerType playerType) {
        if (playerType == null) {
            throw new CannotCreatePlayerWithoutStrategy("Strategy not set");
        }
        this.score = 0;
        this.move = playerType.getMove();
    }

    private void invest() {
        this.score += 3;
    }

    private void deduct() {
        this.score--;
    }

    public void playWith(Player anotherPlayer) {
        if (this.move == Move.COOPERATE) {
            this.deduct();
            anotherPlayer.invest();
        }
        if (anotherPlayer.getMove() == Move.COOPERATE) {
            this.invest();
            anotherPlayer.deduct();
        }
    }

    private Move getMove() {
        return move;
    }

    public int getScore() {
        return score;
    }
}
