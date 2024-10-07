package org.example.Entities;

import org.example.Strategy.AlwaysCheat;
import org.example.Strategy.AlwaysCooperate;
import org.example.Strategy.PlayerStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void TestPlayerInitialization() {
        assertDoesNotThrow(() -> new Player(new AlwaysCooperate()));
    }

    @Test
    void TestPlayerScoreInitialization() {
        Player player = new Player(new AlwaysCheat());
        assertEquals(0, player.score);
    }
}