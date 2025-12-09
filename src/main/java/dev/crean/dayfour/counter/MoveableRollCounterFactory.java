package dev.crean.dayfour.counter;

public class MoveableRollCounterFactory {
    public static MoveableRollCounter createFirstMatchMoveableCounter() {
        return new FirstMatchMoveableCounter();
    }

    public static MoveableRollCounter createAllMatchMoveableCounter() {
        return new AllMatchMoveableCounter();
    }
}
