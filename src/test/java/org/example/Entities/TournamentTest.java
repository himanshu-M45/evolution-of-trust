package org.example.Entities;

import org.example.Exceptions.InvalidTournamentArgsException;
import org.example.Strategy.AllCheat;
import org.example.Strategy.AllCooperate;
import org.example.Strategy.Copycat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TournamentTest {
    private final List<Player> players = new ArrayList<>();

    @BeforeEach
    void setUp() {
        // Create 3 players of each type
        for (int i = 0; i < 3; i++) {
            players.add(new Player(new AllCheat()));
            players.add(new Player(new AllCooperate()));
            players.add(new Player(new Copycat()));
        }
    }

    @Test
    @Tag("tournamentInitialization")
    void testTournamentInitialization() {
        assertDoesNotThrow(() -> new Tournament(players, 4, 2));
    }

    @Test
    @Tag("tournamentInitialization")
    void testTournamentInitializationWithInvalidPlayers() {
        List<Player> emptyPlayers = new ArrayList<>();
        assertThrows(InvalidTournamentArgsException.class, () -> new Tournament(emptyPlayers, 4, 2));
    }

    @Test
    @Tag("tournamentInitialization")
    void testTournamentInitializationWithInvalidRounds() {
        assertThrows(InvalidTournamentArgsException.class, () -> new Tournament(players, 3, 2));
    }

    @Test
    @Tag("tournamentInitialization")
    void testTournamentInitializationWithInvalidNumberOfUpdates() {
        assertThrows(InvalidTournamentArgsException.class, () -> new Tournament(players, 4, 1));
    }

    @Test
    @Tag("playTournament")
    void testPlayTournament() {
        Tournament tournament = new Tournament(players, 3, 5);
        tournament.play();
        assertTrue(tournament.isAllPlayerTypeSame());
    }

    @Test
    @Tag("playTournament")
    void testPlayTournamentWith5RoundsEach() {
        List<Player> allCheatPlayers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            allCheatPlayers.add(new Player(new AllCheat()));
        }
        Tournament tournament = new Tournament(allCheatPlayers, 5, 5);
        tournament.play();
        assertTrue(tournament.isAllPlayerTypeSame());
    }
}