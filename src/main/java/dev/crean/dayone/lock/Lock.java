package dev.crean.dayone.lock;

public interface Lock {
    void turn(LockTurn lock);

    int getPassword();
}
