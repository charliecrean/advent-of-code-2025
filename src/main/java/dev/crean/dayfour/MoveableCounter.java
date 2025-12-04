package dev.crean.dayfour;

import java.util.List;
import java.util.function.BiConsumer;

abstract class MoveableCounter implements MoveableRollCounter {
    int[][] totals;
    List<List<Character>> originalGrid;
    boolean isInitialised = false;

    @Override
    public void init(List<List<Character>> originalGrid) {
        this.originalGrid = originalGrid;
        this.totals = new int[originalGrid.size()][originalGrid.getFirst().size()];
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
                if ((i != row || j != col) && canAdjust(i, j)) {
                    action.accept(i, j);
                }
            }
        }
    }

    private boolean canAdjust(int row, int col) {
        if (row < 0 || row >= originalGrid.size()) {
            return false;
        }
        if (col < 0 || col >= originalGrid.getFirst().size()) {
            return false;
        }
        return originalGrid.get(row).get(col) == '@';
    }

    private void increment(int row, int col) {
        totals[row][col] += 1;
    }

    protected void decrement(int row, int col) {
        totals[row][col] -= 1;
    }
}
