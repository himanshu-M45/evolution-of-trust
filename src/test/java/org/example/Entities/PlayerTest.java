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
}