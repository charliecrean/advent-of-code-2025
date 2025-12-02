package dev.crean.dayone;

interface Lock {
    void turn(LockTurn lock);

    int getPassword();
}
