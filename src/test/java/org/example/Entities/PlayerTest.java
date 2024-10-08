package org.example.Entities;

import org.example.Exceptions.CannotCreatePlayerWithoutStrategy;
import org.example.Strategy.AlwaysCheat;
import org.example.Strategy.AlwaysCooperate;
import org.example.Strategy.Copycat;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    @Tag("playerInitialization")
    void TestPlayerInitialization() {
        assertDoesNotThrow(() -> new Player(new AlwaysCheat()));
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
    @Tag("playWith")
    void TestAlwaysCheatPlayerPlayWithAlwaysCooperatePlayer() {
        Player firstPlayer = new Player(new AlwaysCheat());
        Player secondPlayer = new Player(new AlwaysCooperate());
        firstPlayer.playWith(secondPlayer);
        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    @Test
    @Tag("playWith")
    void TestAlwaysCooperatePlayerPlayWithAlwaysCooperatePlayer() {
        Player firstPlayer = new Player(new AlwaysCooperate());
        Player secondPlayer = new Player(new AlwaysCooperate());
        firstPlayer.playWith(secondPlayer);
        assertEquals(2, firstPlayer.getScore());
        assertEquals(2, secondPlayer.getScore());
    }

    @Test
    @Tag("playWith")
    void TestAlwaysCheatPlayerPlayWithAlwaysCheatPlayer() {
        Player firstPlayer = new Player(new AlwaysCheat());
        Player secondPlayer = new Player(new AlwaysCheat());
        firstPlayer.playWith(secondPlayer);
        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    @Tag("playWith")
    void TestCopycatPlayerPlayWithAlwaysCheatPlayer() {
        Player firstPlayer = new Player(new Copycat());
        Player secondPlayer = new Player(new AlwaysCheat());
        firstPlayer.playWith(secondPlayer);
        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    @Tag("playWith")
    void TestCopycatPlayerPlayWithAlwaysCooperatePlayer() {
        Player firstPlayer = new Player(new Copycat());
        Player secondPlayer = new Player(new AlwaysCooperate());
        firstPlayer.playWith(secondPlayer);
        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    @Test
    @Tag("playWith")
    void TestCopycatPlayerPlayWithCopycatPlayer() {
        Player firstPlayer = new Player(new Copycat());
        Player secondPlayer = new Player(new Copycat());
        firstPlayer.playWith(secondPlayer);
        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }
}