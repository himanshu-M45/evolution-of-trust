package org.example.Entities;

import org.example.Exceptions.InvalidTournamentArgsException;
import org.example.Strategy.PlayerStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tournament {
    private final List<Player> players;
    private final int rounds;
    private final int turnoverCount;

    public Tournament(List<Player> players, int rounds, int turnoverCount) {
        if (players.isEmpty() || rounds < 2 || turnoverCount < 1) {
            throw new InvalidTournamentArgsException("Invalid input");
        }
        this.players = players;
        this.rounds = rounds;
        this.turnoverCount = turnoverCount;
    }

    public void play() {
        while (!isAllPlayerTypeSame()) {
            conductMatches(); // play all players against each other
            eliminateBottomPlayers(); // eliminate the bottom players
            reproduceTopPlayers(); // reproduce the top players
            reinitializePlayers(); // reinitialize the players
        }
    }

    public boolean isAllPlayerTypeSame() {
        Class<?> topPlayerType = players.getFirst().getStrategy().getClass();
        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).getStrategy().getClass() != topPlayerType) {
                return false;
            }
        }
        return true;
    }

    private void conductMatches() {
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.size(); j++) {
                if (i != j) {
                    Player player1 = players.get(i);
                    Player player2 = players.get(j);
                    Game game = new Game(player1, player2);
                    game.play(rounds);
                }
            }
        }
    }

    private void eliminateBottomPlayers() {
        players.sort(Comparator.comparingInt(Player::getScore).reversed());

        // Remove the specified number of players from the end of the list
        for (int i = 0; i < turnoverCount && !players.isEmpty(); i++) {
            players.removeLast();
        }
    }

    private void reproduceTopPlayers() {
        for (int i = 0; i < turnoverCount; i++) {
            Player player = players.get(i);
            players.add(new Player(player.getStrategy()));
        }
    }

    private void reinitializePlayers() {
        List<Player> clonedPlayers = new ArrayList<>();
        for (Player player : players) {
            clonedPlayers.add(player.clone());
        }
        players.clear();
        players.addAll(clonedPlayers);
    }
}
