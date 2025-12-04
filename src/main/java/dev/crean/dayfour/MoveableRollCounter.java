package dev.crean.dayfour;

import java.util.List;

public interface MoveableRollCounter {
    void init(List<List<Character>> originalGrid);

    void count(int row, int col);

    int getMoveableRollCount();
}
