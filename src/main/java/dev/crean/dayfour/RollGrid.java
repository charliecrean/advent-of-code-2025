package dev.crean.dayfour;

import java.util.List;

public class RollGrid {
    List<List<Character>> inputChars;
    MoveableRollCounter counter;

    public RollGrid(List<List<Character>> inputChars, MoveableRollCounter counter) {
        this.inputChars = inputChars;
        this.counter = counter;
        counter.init(inputChars);
        validateInput();
    }

    private void validateInput() {
        int size = inputChars.getFirst().size();
        if(!inputChars.stream().allMatch(list -> list.size() == size)) {
            throw new RuntimeException("Invalid input. Expected all rows to be of equal length.");
        }

    }

    public int compute() {
         for (int i = 0; i < inputChars.size(); i++) {
            List<Character> row = inputChars.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (row.get(j).equals('@')) {
                    counter.count(i, j);
                }
            }
        }

        return counter.getMoveableRollCount();
    }
}

