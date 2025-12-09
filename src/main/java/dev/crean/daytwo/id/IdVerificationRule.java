package dev.crean.daytwo.id;

public interface IdVerificationRule {
    boolean isValid(long id);
}
