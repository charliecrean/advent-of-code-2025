package dev.crean.dayfour;

import dev.crean.dayfour.counter.MoveableRollCounterFactory;
import dev.crean.utils.Input;
import dev.crean.utils.SampleInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoveTheRollsTest {

    @Test
    public void testSampleOne() {
        MoveTheRolls instance = new MoveTheRolls(SampleInput.DAY_FOUR, MoveableRollCounterFactory.createFirstMatchMoveableCounter());
        int result = instance.findMoveableRollCount();
        Assertions.assertEquals(13, result);
    }

    @Test
    public void testSampleTwo() {
        MoveTheRolls instance = new MoveTheRolls(SampleInput.DAY_FOUR, MoveableRollCounterFactory.createAllMatchMoveableCounter());
        int result = instance.findMoveableRollCount();
        Assertions.assertEquals(43, result);
    }

    @Test
    public void testPartOne() {
        MoveTheRolls instance = new MoveTheRolls(Input.DAY_FOUR, MoveableRollCounterFactory.createFirstMatchMoveableCounter());
        int result = instance.findMoveableRollCount();
        Assertions.assertEquals(1587, result);
    }

    @Test
    public void testPartTwo() {
        MoveTheRolls instance = new MoveTheRolls(Input.DAY_FOUR, MoveableRollCounterFactory.createAllMatchMoveableCounter());
        int result = instance.findMoveableRollCount();
        Assertions.assertEquals(8946, result);
    }

}
