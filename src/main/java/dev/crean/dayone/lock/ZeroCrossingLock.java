package dev.crean.dayone.lock;

class ZeroCrossingLock implements Lock {
    private int currentPointer = 50;
    private int zeroCrosses = 0;

    @Override
    public void turn(LockTurn turn) {
        int prevPointer = currentPointer;
        int newPos = currentPointer + (turn.direction * turn.numberOfTurns);

        currentPointer = (newPos + 100) % 100;
        zeroCrosses += turn.fullRotations;

        if ((prevPointer != 0 && (newPos < 0 || newPos > 99)) || currentPointer == 0) zeroCrosses += 1;
    }

    @Override
    public int getPassword() {
        return getZeroCrosses();
    }

    public int getZeroCrosses() {
        return zeroCrosses;
    }
}
