package dev.crean.dayone;

import dev.crean.dayone.lock.Lock;
import dev.crean.dayone.lock.LockTurn;
import dev.crean.utils.FileHandler;

public class FindPassword {
    private final String path;
    private final Lock lock;

    public FindPassword(String path, Lock lock) {
        this.path = path;
        this.lock = lock;
    }

    public long find() {
        FileHandler<LockTurn> parser = new FileHandler<>(path);
        parser.processFileLines(LockTurn::new, lock::turn);
        return lock.getPassword();
    }
}

