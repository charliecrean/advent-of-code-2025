package dev.crean.utils;

abstract class BaseFileInput {
    private static final String PATH = "aocResources/%s/day-%s.txt";

    protected static final String ONE = "one";
    protected static final String TWO = "two";
    protected static final String THREE = "three";
    protected static final String FOUR = "four";
    protected static final String FIVE = "five";
    protected static final String SIX = "six";
    protected static final String SEVEN = "seven";
    protected static final String EIGHT = "eight";

    protected static String buildPath(String dir, String input) {
        return String.format(PATH, dir, input);
    }
}
