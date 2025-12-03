package dev.crean.daytwo;

record IdRange(long lower, long higher) {
    IdRange(String input) {
        String[] range = input.split("-");
        this(Long.parseLong(range[0]), Long.parseLong(range[1]));
    }
}
