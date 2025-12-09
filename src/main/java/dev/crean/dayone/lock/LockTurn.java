package dev.crean.dayone.lock;

public class LockTurn {
    int direction;
    int numberOfTurns;
    int fullRotations = 0;

    public LockTurn(String input) {
        if (input == null || input.length() < 2) {
            throw new RuntimeException("Input " + input + " is invalid.");
        }
        parseInput(input);
    }

    private void parseInput(String input) {
        if (input.charAt(0) != 'R' && input.charAt(0) != 'L') {
            throw new RuntimeException("Input " + input + " must start with \"R\" or \"L\".");
        }
        direction = input.charAt(0) == 'R' ? 1 : -1;
        try {
            numberOfTurns = Integer.parseInt(input.substring(1));
        } catch (NumberFormatException ex) {
            throw new RuntimeException("Input " + input + " must end with a valid integer.");
        }

        if (numberOfTurns > 99) {
            fullRotations = numberOfTurns / 100;
            numberOfTurns = numberOfTurns % 100;
        }
    }
}
