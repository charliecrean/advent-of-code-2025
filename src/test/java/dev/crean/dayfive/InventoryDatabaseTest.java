package dev.crean.dayfive;

import dev.crean.utils.Input;
import dev.crean.utils.SampleInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

@DisabledIfEnvironmentVariable(named = "CI", matches = "true")
public class InventoryDatabaseTest {
    @Test
    public void testSampleOne() {
        InventoryDatabase instance = new InventoryDatabase(SampleInput.DAY_FIVE);
        long result = instance.getFreshProductCount();
        Assertions.assertEquals(3L, result);
    }

    @Test
    public void testSampleTwo() {
        InventoryDatabase instance = new InventoryDatabase(SampleInput.DAY_FIVE);
        long result = instance.getTotalAvailableFreshIds();
        Assertions.assertEquals(14L, result);
    }

    @Test
    public void testPartOne() {
        InventoryDatabase instance = new InventoryDatabase(Input.DAY_FIVE);
        long result = instance.getFreshProductCount();
        Assertions.assertEquals(598L, result);
    }

    @Test
    public void testPartTwo() {
        InventoryDatabase instance = new InventoryDatabase(Input.DAY_FIVE);
        long result = instance.getTotalAvailableFreshIds();
        Assertions.assertEquals(360341832208407L, result);
    }

}
