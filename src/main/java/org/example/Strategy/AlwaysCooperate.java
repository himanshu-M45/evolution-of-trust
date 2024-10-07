package org.example.Strategy;

public class AlwaysCooperate extends PlayerStrategy {
    @Override
    public int getMove() {
        return 1;
    }
}
