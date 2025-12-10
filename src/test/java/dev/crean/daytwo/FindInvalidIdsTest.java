package dev.crean.daytwo;

import dev.crean.daytwo.id.IdVerificationRuleFactory;
import dev.crean.utils.Input;
import dev.crean.utils.SampleInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

@DisabledIfEnvironmentVariable(named = "CI", matches = "true")
public class FindInvalidIdsTest {
    @Test
    public void testSampleOne() {
        FindInvalidIds instance = new FindInvalidIds(SampleInput.DAY_TWO, IdVerificationRuleFactory.createIdCannotHaveRepeatedSequenceTwiceRule());
        long result = instance.find();
        Assertions.assertEquals(1227775554L, result);
    }

    @Test
    public void testSampleTwo() {
        FindInvalidIds instance = new FindInvalidIds(SampleInput.DAY_TWO, IdVerificationRuleFactory.createIdCannotHaveAnyRepeatedSequenceRule());
        long result = instance.find();
        Assertions.assertEquals(4174379265L, result);
    }

    @Test
    public void testPartOne() {
        FindInvalidIds instance = new FindInvalidIds(Input.DAY_TWO, IdVerificationRuleFactory.createIdCannotHaveRepeatedSequenceTwiceRule());
        long result = instance.find();
        Assertions.assertEquals(56660955519L, result);
    }

    @Test
    public void testPartTwo() {
        FindInvalidIds instance = new FindInvalidIds(Input.DAY_TWO, IdVerificationRuleFactory.createIdCannotHaveAnyRepeatedSequenceRule());
        long result = instance.find();
        Assertions.assertEquals(79183223243L, result);
    }

}
