package org.example.Entities;

import org.example.Enum.PlayerMove;
import org.example.Exceptions.CannotCreatePlayerWithoutStrategy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    @Tag("playerInitialization")
    void TestPlayerInitialization() {
        assertDoesNotThrow(() -> new Player(PlayerMove.ALWAYS_CHEAT));
    }

    @Test
    @Tag("playerInitialization")
    void TestPlayerInitializationWithNullStrategy() {
        assertThrows(CannotCreatePlayerWithoutStrategy.class, () -> new Player(null));
    }

    @Test
    @Tag("playerInitialization")
    void TestPlayerScoreInitialization() {
        Player player = new Player(PlayerMove.ALWAYS_CHEAT);
        assertEquals(0, player.getScore());
    }

    @Test
    @Tag("strategyTest")
    void TestPlayerMoveAccordingToAlwaysCooperateStrategy() {
        Player player = new Player(PlayerMove.ALWAYS_COOPERATE);
        assertEquals(PlayerMove.ALWAYS_COOPERATE, player.getPlayerInput());
    }

    @Test
    @Tag("strategyTest")
    void TestPlayerMoveAccordingToAlwaysCheatStrategy() {
        Player player = new Player(PlayerMove.ALWAYS_CHEAT);
        assertEquals(PlayerMove.ALWAYS_CHEAT, player.getPlayerInput());
    }
}