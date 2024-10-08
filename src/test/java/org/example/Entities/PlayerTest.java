package org.example.Entities;

import org.example.Enum.PlayerType;
import org.example.Exceptions.CannotCreatePlayerWithoutStrategy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    @Tag("playerInitialization")
    void TestPlayerInitialization() {
        assertDoesNotThrow(() -> new Player(PlayerType.ALWAYS_CHEAT));
    }

    @Test
    @Tag("playerInitialization")
    void TestPlayerInitializationWithNullStrategy() {
        assertThrows(CannotCreatePlayerWithoutStrategy.class, () -> new Player(null));
    }

    @Test
    @Tag("playerInitialization")
    void TestPlayerScoreInitialization() {
        Player player = new Player(PlayerType.ALWAYS_CHEAT);
        assertEquals(0, player.getScore());
    }

    @Test
    @Tag("playWith")
    void TestAlwaysCheatPlayerPlayWithAlwaysCooperatePlayer() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Player secondPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        firstPlayer.playWith(secondPlayer);
        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    @Test
    @Tag("playWith")
    void TestAlwaysCooperatePlayerPlayWithAlwaysCooperatePlayer() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Player secondPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        firstPlayer.playWith(secondPlayer);
        assertEquals(2, firstPlayer.getScore());
        assertEquals(2, secondPlayer.getScore());
    }

    @Test
    @Tag("playWith")
    void TestAlwaysCheatPlayerPlayWithAlwaysCheatPlayer() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Player secondPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        firstPlayer.playWith(secondPlayer);
        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    @Tag("playWith")
    void TestCopycatPlayerPlayWithAlwaysCheatPlayer() {
        Player firstPlayer = new Player(PlayerType.COPYCAT);
        Player secondPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        firstPlayer.playWith(secondPlayer);
        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    @Tag("playWith")
    void TestCopycatPlayerPlayWithAlwaysCooperatePlayer() {
        Player firstPlayer = new Player(PlayerType.COPYCAT);
        Player secondPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        firstPlayer.playWith(secondPlayer);
        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    @Test
    @Tag("playWith")
    void TestCopycatPlayerPlayWithCopycatPlayer() {
        Player firstPlayer = new Player(PlayerType.COPYCAT);
        Player secondPlayer = new Player(PlayerType.COPYCAT);
        firstPlayer.playWith(secondPlayer);
        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }
}