package org.example.Entities;

import org.example.Enum.PlayerType;
import org.example.Exceptions.CannotInitialteGameWihoutPlayers;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    @Tag("gameInitialization")
    void TestGameInitialization() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Player secondPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        assertDoesNotThrow(() -> new Game(firstPlayer, secondPlayer));
    }

    @Test
    @Tag("gameInitialization")
    void TestGameInitializationWithNullPlayer() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        assertThrows(CannotInitialteGameWihoutPlayers.class, () -> new Game(firstPlayer, null));
    }

    @Test
    @Tag("playGame")
    void TestPlayGameWithBothCheatPlayers() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Player secondPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(1);
        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestPlayGameWithBothCooperatePlayers() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Player secondPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(1);
        assertEquals(2, firstPlayer.getScore());
        assertEquals(2, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestPlayGameOneCheatPlayerAndOneCooperatePlayer() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Player secondPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(1);
        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestPlay5RoundWithBothCheatPlayersAnd0Score() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Player secondPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(5);
        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestPlay5RoundWithBothCooperatePlayersAnd10Score() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Player secondPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(5);
        assertEquals(10, firstPlayer.getScore());
        assertEquals(10, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestPlay5RoundWithOneCheatPlayerAndOneCooperatePlayers() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Player secondPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(5);
        assertEquals(15, firstPlayer.getScore());
        assertEquals(-5, secondPlayer.getScore());
    }
}