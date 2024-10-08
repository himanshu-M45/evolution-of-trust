package org.example.Entities;

import org.example.Exceptions.CannotInitialteGameWihoutPlayers;
import org.example.Strategy.AllCheat;
import org.example.Strategy.AllCooperate;
import org.example.Strategy.Copycat;
import org.example.Strategy.Detective;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    @Tag("gameInitialization")
    void TestGameInitialization() {
        Player firstPlayer = new Player(new AllCooperate());
        Player secondPlayer = new Player(new AllCheat());
        assertDoesNotThrow(() -> new Game(firstPlayer, secondPlayer));
    }

    @Test
    @Tag("gameInitialization")
    void TestGameInitializationWithNullPlayer() {
        Player firstPlayer = new Player(new AllCooperate());
        assertThrows(CannotInitialteGameWihoutPlayers.class, () -> new Game(firstPlayer, null));
    }

    @Test
    @Tag("playGame")
    void TestPlayGameWithBothCheatPlayers() {
        Player firstPlayer = new Player(new AllCheat());
        Player secondPlayer = new Player(new AllCheat());
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(1);
        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestPlayGameWithBothCooperatePlayers() {
        Player firstPlayer = new Player(new AllCooperate());
        Player secondPlayer = new Player(new AllCooperate());
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(1);
        assertEquals(2, firstPlayer.getScore());
        assertEquals(2, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestPlayGameOneCheatPlayerAndOneCooperatePlayer() {
        Player firstPlayer = new Player(new AllCheat());
        Player secondPlayer = new Player(new AllCooperate());
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(1);
        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestBothPlayersCheatFor5Rounds() {
        Player firstPlayer = new Player(new AllCheat());
        Player secondPlayer = new Player(new AllCheat());
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(5);
        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestBothPlayersCooperateFor5Rounds() {
        Player firstPlayer = new Player(new AllCooperate());
        Player secondPlayer = new Player(new AllCooperate());
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(5);
        assertEquals(10, firstPlayer.getScore());
        assertEquals(10, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestFirstPlayerCheatAndSecondPlayerCooperatesFor5Rounds() {
        Player firstPlayer = new Player(new AllCheat());
        Player secondPlayer = new Player(new AllCooperate());
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(5);
        assertEquals(15, firstPlayer.getScore());
        assertEquals(-5, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestFirstPlayerCooperatesAndSecondPlayerCheatsFor5Rounds() {
        Player firstPlayer = new Player(new AllCooperate());
        Player secondPlayer = new Player(new AllCheat());
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(5);
        assertEquals(-5, firstPlayer.getScore());
        assertEquals(15, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestFirstPlayerAlwaysCooperatesAndSecondPlayerIsCopycat() {
        Player firstPlayer = new Player(new AllCooperate());
        Player secondPlayer = new Player(new Copycat());
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(5);
        assertEquals(7, firstPlayer.getScore());
        assertEquals(11, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestFirstPlayerAlwaysCheatsAndSecondPlayerIsCopycat() {
        Player firstPlayer = new Player(new AllCheat());
        Player secondPlayer = new Player(new Copycat());
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(5);
        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestFirstPlayerIsCopycatAndSecondPlayerAlwaysCooperates() {
        Player firstPlayer = new Player(new Copycat());
        Player secondPlayer = new Player(new AllCooperate());
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(7);
        assertEquals(15, firstPlayer.getScore());
        assertEquals(11, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestFirstPlayerCooperatesAndSecondPlayerDetective() {
        Player firstPlayer = new Player(new AllCooperate());
        Player secondPlayer = new Player(new Detective());
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(5);
        assertEquals(4, firstPlayer.getScore());
        assertEquals(12, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestFirstPlayerDetectiveAndSecondPlayerDetective() {
        Player firstPlayer = new Player(new Detective());
        Player secondPlayer = new Player(new Detective());
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(5);
        assertEquals(8, firstPlayer.getScore());
        assertEquals(8, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestFirstPlayerDetectiveAndSecondPlayerAlwaysCooperates() {
        Player firstPlayer = new Player(new Detective());
        Player secondPlayer = new Player(new AllCooperate());
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(5);
        assertEquals(12, firstPlayer.getScore());
        assertEquals(4, secondPlayer.getScore());
    }

    @Test
    @Tag("playGame")
    void TestFirstPlayerDetectiveAndSecondPlayerAlwaysCheats() {
        Player firstPlayer = new Player(new Detective());
        Player secondPlayer = new Player(new AllCheat());
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(5);
        assertEquals(-3, firstPlayer.getScore());
        assertEquals(9, secondPlayer.getScore());

        Player allCooperate = new Player(new AllCooperate());
        firstPlayer.playWith(allCooperate);
        assertEquals(0, firstPlayer.getScore());
        assertEquals(-1, allCooperate.getScore());

        firstPlayer.playWith(allCooperate);
        assertEquals(2, firstPlayer.getScore());
        assertEquals(1, allCooperate.getScore());
    }

    @Test
    @Tag("playGame")
    void TestFirstPlayerDetectiveAndSecondPlayerCopycat() {
        Player firstPlayer = new Player(new Detective());
        Player secondPlayer = new Player(new Copycat());
        Game game = new Game(firstPlayer, secondPlayer);
        game.play(5);
        assertEquals(5, firstPlayer.getScore());
        assertEquals(9, secondPlayer.getScore());
    }
}