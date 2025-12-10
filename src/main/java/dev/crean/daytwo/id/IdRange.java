package dev.crean.daytwo.id;

public record IdRange(long lower, long higher) {

    IdRange(String input) {
        this(Long.parseLong(input.split("-")[0]), Long.parseLong(input.split("-")[1]));
    }
}
