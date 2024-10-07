package org.example.Entities;

import org.example.Enum.PlayerMove;
import org.example.Exceptions.CannotInitialteGameWihoutPlayers;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    @Tag("gameInitialization")
    void TestGameInitialization() {
        Player player1 = new Player(PlayerMove.ALWAYS_COOPERATE);
        Player player2 = new Player(PlayerMove.ALWAYS_CHEAT);
        assertDoesNotThrow(() -> new Game(player1, player2));
    }

    @Test
    @Tag("gameInitialization")
    void TestGameInitializationWithNullPlayer() {
        Player player1 = new Player(PlayerMove.ALWAYS_COOPERATE);
        assertThrows(CannotInitialteGameWihoutPlayers.class, () -> new Game(player1, null));
    }

    @Test
    @Tag("playGame")
    void TestPlayGameWithBothCheatPlayers() {
        Player player1 = new Player(PlayerMove.ALWAYS_CHEAT);
        Player player2 = new Player(PlayerMove.ALWAYS_CHEAT);
        Game game = new Game(player1, player2);
        game.play(1);
        assertEquals(0, player1.getScore());
        assertEquals(0, player2.getScore());
    }

    @Test
    @Tag("playGame")
    void TestPlayGameWithBothCooperatePlayers() {
        Player player1 = new Player(PlayerMove.ALWAYS_COOPERATE);
        Player player2 = new Player(PlayerMove.ALWAYS_COOPERATE);
        Game game = new Game(player1, player2);
        game.play(1);
        assertEquals(2, player1.getScore());
        assertEquals(2, player2.getScore());
    }

    @Test
    @Tag("playGame")
    void TestPlayGameOneCheatPlayerAndOneCooperatePlayer() {
        Player player1 = new Player(PlayerMove.ALWAYS_CHEAT);
        Player player2 = new Player(PlayerMove.ALWAYS_COOPERATE);
        Game game = new Game(player1, player2);
        game.play(1);
        assertEquals(3, player1.getScore());
        assertEquals(-1, player2.getScore());
    }

    @Test
    @Tag("playGame")
    void TestPlay5RoundWithBothCheatPlayersAnd0Score() {
        Player player1 = new Player(PlayerMove.ALWAYS_CHEAT);
        Player player2 = new Player(PlayerMove.ALWAYS_CHEAT);
        Game game = new Game(player1, player2);
        game.play(5);
        assertEquals(0, player1.getScore());
        assertEquals(0, player2.getScore());
    }

    @Test
    @Tag("playGame")
    void TestPlay5RoundWithBothCooperatePlayersAnd10Score() {
        Player player1 = new Player(PlayerMove.ALWAYS_COOPERATE);
        Player player2 = new Player(PlayerMove.ALWAYS_COOPERATE);
        Game game = new Game(player1, player2);
        game.play(5);
        assertEquals(10, player1.getScore());
        assertEquals(10, player2.getScore());
    }

    @Test
    @Tag("playGame")
    void TestPlay5RoundWithOneCheatPlayerAndOneCooperatePlayers() {
        Player player1 = new Player(PlayerMove.ALWAYS_CHEAT);
        Player player2 = new Player(PlayerMove.ALWAYS_COOPERATE);
        Game game = new Game(player1, player2);
        game.play(5);
        assertEquals(15, player1.getScore());
        assertEquals(-5, player2.getScore());
    }
}