package org.example.Entities;

import org.example.Exceptions.CannotCreatePlayerWithoutStrategy;
import org.example.Strategy.AllCheat;
import org.example.Strategy.AllCooperate;
import org.example.Strategy.Copycat;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    @Tag("playerInitialization")
    void TestPlayerInitialization() {
        assertDoesNotThrow(() -> new Player(new AllCheat()));
    }

    @Test
    @Tag("playerInitialization")
    void TestPlayerInitializationWithNullStrategy() {
        assertThrows(CannotCreatePlayerWithoutStrategy.class, () -> new Player(null));
    }

    @Test
    @Tag("playerInitialization")
    void TestPlayerScoreInitialization() {
        Player player = new Player(new AllCheat());
        assertEquals(0, player.getScore());
    }

    @Test
    @Tag("playWith")
    void TestAlwaysCheatPlayerPlayWithAlwaysCooperatePlayer() {
        Player firstPlayer = new Player(new AllCheat());
        Player secondPlayer = new Player(new AllCooperate());
        firstPlayer.playWith(secondPlayer);
        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    @Test
    @Tag("playWith")
    void TestAlwaysCooperatePlayerPlayWithAlwaysCooperatePlayer() {
        Player firstPlayer = new Player(new AllCooperate());
        Player secondPlayer = new Player(new AllCooperate());
        firstPlayer.playWith(secondPlayer);
        assertEquals(2, firstPlayer.getScore());
        assertEquals(2, secondPlayer.getScore());
    }

    @Test
    @Tag("playWith")
    void TestAlwaysCheatPlayerPlayWithAlwaysCheatPlayer() {
        Player firstPlayer = new Player(new AllCheat());
        Player secondPlayer = new Player(new AllCheat());
        firstPlayer.playWith(secondPlayer);
        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    @Tag("playWith")
    void TestCopycatPlayerPlayWithAlwaysCheatPlayer() {
        Player firstPlayer = new Player(new Copycat());
        Player secondPlayer = new Player(new AllCheat());
        firstPlayer.playWith(secondPlayer);
        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    @Tag("playWith")
    void TestCopycatPlayerPlayWithAlwaysCooperatePlayer() {
        Player firstPlayer = new Player(new Copycat());
        Player secondPlayer = new Player(new AllCooperate());
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