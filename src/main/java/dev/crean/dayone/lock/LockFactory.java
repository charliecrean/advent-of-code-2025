package dev.crean.dayone.lock;

public class LockFactory {
    public static Lock createZeroLandingLock() {
        return new ZeroLandingLock();
    }

    public static Lock createZeroCrossingLock() {
        return new ZeroCrossingLock();
    }
}
