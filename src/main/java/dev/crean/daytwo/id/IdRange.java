package dev.crean.daytwo.id;

public record IdRange(long lower, long higher) {
    IdRange(String input) {
        String[] range = input.split("-");
        this(Long.parseLong(range[0]), Long.parseLong(range[1]));
    }
}
