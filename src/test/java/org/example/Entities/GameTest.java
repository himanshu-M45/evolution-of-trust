package org.example.Entities;

import org.example.Exceptions.CannotInitialteGameWihoutPlayers;
import org.example.Strategy.AlwaysCheat;
import org.example.Strategy.AlwaysCooperate;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    @Tag("gameInitialization")
    void TestGameInitialization() {
        Player player1 = new Player(new AlwaysCooperate());
        Player player2 = new Player(new AlwaysCheat());
        assertDoesNotThrow(() -> new Game(player1, player2));
    }

    @Test
    @Tag("gameInitialization")
    void TestGameInitializationWithNullPlayer() {
        Player player1 = new Player(new AlwaysCooperate());
        assertThrows(CannotInitialteGameWihoutPlayers.class, () -> new Game(player1, null));
    }

    @Test
    @Tag("playGame")
    void TestPlayGameWithBothCheatPlayers() {
        Player player1 = new Player(new AlwaysCheat());
        Player player2 = new Player(new AlwaysCheat());
        Game game = new Game(player1, player2);
        game.play();
        assertEquals(0, player1.getScore());
        assertEquals(0, player2.getScore());
    }

    @Test
    @Tag("playGame")
    void TestPlayGameWithBothCooperatePlayers() {
        Player player1 = new Player(new AlwaysCooperate());
        Player player2 = new Player(new AlwaysCooperate());
        Game game = new Game(player1, player2);
        game.play();
        assertEquals(2, player1.getScore());
        assertEquals(2, player2.getScore());
    }

    @Test
    @Tag("playGame")
    void TestPlayGameOneCheatPlayerAndOneCooperatePlayer() {
        Player player1 = new Player(new AlwaysCheat());
        Player player2 = new Player(new AlwaysCooperate());
        Game game = new Game(player1, player2);
        game.play();
        assertEquals(3, player1.getScore());
        assertEquals(-1, player2.getScore());
    }
}