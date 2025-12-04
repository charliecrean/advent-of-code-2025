package dev.crean.dayfour;

import java.util.List;
import java.util.function.BiConsumer;

abstract class MoveableCounter implements MoveableRollCounter {
    int[][] totals;
    int rows;
    int cols;
    List<List<Character>> originalGrid;

    boolean isInitialised = false;

    @Override
    public void init(List<List<Character>> originalGrid) {
        this.originalGrid = originalGrid;
        this.rows = originalGrid.size();
        this.cols = originalGrid.getFirst().size();
        this.totals = new int[rows][cols];
        this.isInitialised = true;
    }

    @Override
    public void count(int row, int col) {
        adjust(row, col, this::increment);
    }

    protected void adjust(int row, int col, BiConsumer<Integer, Integer> action) {
        if(!this.isInitialised) {
            throw new RuntimeException("Counter not yet initialised.");
        }
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i != row || j != col) {
                    action.accept(i, j);
                }
            }
        }
    }

    private void increment(int row, int col) {
        if (row < 0 || row >= rows) {
            return;
        }
        if (col < 0 || col >= cols) {
            return;
        }
        if (originalGrid.get(row).get(col) != '@') {
            return;
        }
        totals[row][col] += 1;
    }

    protected void decrement(int row, int col) {
        if (row < 0 || row >= rows) {
            return;
        }
        if (col < 0 || col >= cols) {
            return;
        }
        if (originalGrid.get(row).get(col) != '@') {
            return;
        }
        totals[row][col] -= 1;
    }
}
