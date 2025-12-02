package dev.crean.dayone;

class ZeroLandingLock implements Lock {
    private int currentPointer = 50;
    private int zeroOccurrences = 0;

    @Override
    public void turn(LockTurn turn) {
        int newPos = currentPointer + (turn.direction * turn.numberOfTurns);

        currentPointer = (newPos + 100) % 100;

        if (currentPointer == 0) zeroOccurrences += 1;
    }

    @Override
    public int getPassword() {
        return getZeroOccurrences();
    }

    public int getZeroOccurrences() {
        return zeroOccurrences;
    }
}
