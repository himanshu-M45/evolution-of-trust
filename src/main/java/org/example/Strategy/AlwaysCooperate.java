package org.example.Strategy;

import org.example.Enum.Move;

public class AlwaysCooperate extends PlayerStrategy {
    @Override
    public int getMove() {
        return 1;
    }
}
