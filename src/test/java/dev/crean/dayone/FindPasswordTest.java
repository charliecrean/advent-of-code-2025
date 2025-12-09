package dev.crean.dayone;

import dev.crean.dayone.lock.LockFactory;
import dev.crean.utils.Input;
import dev.crean.utils.SampleInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindPasswordTest {
    @Test
    public void testSampleOne() {
        FindPassword instance = new FindPassword(SampleInput.DAY_ONE, LockFactory.createZeroLandingLock());
        long result = instance.find();
        Assertions.assertEquals(3L, result);
    }

    @Test
    public void testSampleTwo() {
        FindPassword instance = new FindPassword(SampleInput.DAY_ONE, LockFactory.createZeroCrossingLock());
        long result = instance.find();
        Assertions.assertEquals(6L, result);
    }

    @Test
    public void testPartOne() {
        FindPassword instance = new FindPassword(Input.DAY_ONE, LockFactory.createZeroLandingLock());
        long result = instance.find();
        Assertions.assertEquals(997L, result);
    }

    @Test
    public void testPartTwo() {
        FindPassword instance = new FindPassword(Input.DAY_ONE, LockFactory.createZeroCrossingLock());
        long result = instance.find();
        Assertions.assertEquals(5978L, result);
    }
}
