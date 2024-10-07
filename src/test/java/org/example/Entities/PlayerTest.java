package org.example.Entities;

import org.example.Exceptions.CannotCreatePlayerWithoutStrategy;
import org.example.Strategy.AlwaysCheat;
import org.example.Strategy.AlwaysCooperate;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    @Tag("playerInitialization")
    void TestPlayerInitialization() {
        assertDoesNotThrow(() -> new Player(new AlwaysCooperate()));
    }

    @Test
    @Tag("playerInitialization")
    void TestPlayerInitializationWithNullStrategy() {
        assertThrows(CannotCreatePlayerWithoutStrategy.class, () -> new Player(null));
    }

    @Test
    @Tag("playerInitialization")
    void TestPlayerScoreInitialization() {
        Player player = new Player(new AlwaysCheat());
        assertEquals(0, player.getScore());
    }

    @Test
    @Tag("strategyTest")
    void TestPlayerMoveAccordingToAlwaysCooperateStrategy() {
        Player player = new Player(new AlwaysCooperate());
        assertEquals(1, player.getPlayerInput());
    }

    @Test
    @Tag("strategyTest")
    void TestPlayerMoveAccordingToAlwaysCheatStrategy() {
        Player player = new Player(new AlwaysCheat());
        assertEquals(0, player.getPlayerInput());
    }
}