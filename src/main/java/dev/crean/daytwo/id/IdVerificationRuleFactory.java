package dev.crean.daytwo.id;

public class IdVerificationRuleFactory {

    public static IdVerificationRule createIdCannotHaveAnyRepeatedSequenceRule() {
        return new IdCannotHaveAnyRepeatedSequence();
    }

    public static IdVerificationRule createIdCannotHaveRepeatedSequenceTwiceRule() {
        return new IdCannotHaveRepeatedSequenceTwice();
    }
}
