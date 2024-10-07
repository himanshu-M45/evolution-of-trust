package org.example.Entities;

import org.example.Exceptions.CannotCreatePlayerWithoutStrategy;
import org.example.Strategy.AlwaysCheat;
import org.example.Strategy.AlwaysCooperate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void TestPlayerInitialization() {
        assertDoesNotThrow(() -> new Player(new AlwaysCooperate()));
    }

    @Test
    void TestPlayerInitializationWithNullStrategy() {
        assertThrows(CannotCreatePlayerWithoutStrategy.class, () -> new Player(null));
    }

    @Test
    void TestPlayerScoreInitialization() {
        Player player = new Player(new AlwaysCheat());
        assertEquals(0, player.getScore());
    }

    @Test
    void TestPlayerMoveAccordingToAlwaysCooperateStrategy() {
        Player player = new Player(new AlwaysCooperate());
        assertEquals(1, player.getPlayerInput());
    }

    @Test
    void TestPlayerMoveAccordingToAlwaysCheatStrategy() {
        Player player = new Player(new AlwaysCheat());
        assertEquals(0, player.getPlayerInput());
    }
}