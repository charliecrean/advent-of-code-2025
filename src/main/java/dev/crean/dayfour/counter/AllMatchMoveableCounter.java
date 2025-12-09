package dev.crean.dayfour.counter;

class AllMatchMoveableCounter extends MoveableCounter {

    @Override
    public int getMoveableRollCount() {
        int[][] localTotals = totals.clone();
        int moveable = 0;
        while(true) {
            int latestMoveable = scanForMatches(localTotals);
            if (latestMoveable == 0) {
                break;
            }
            moveable += latestMoveable;
        }
        return moveable;
    }

    private int scanForMatches(int[][] localTotals) {
        int moveable = 0;
        for (int i = 0; i < originalGrid.size(); i++) {
            for (int j = 0; j < originalGrid.getFirst().size(); j++) {
                if (originalGrid.get(i).get(j) == '@' && localTotals[i][j] < 4) {
                    moveable++;
                    adjust(i, j, this::decrement);
                    originalGrid.get(i).set(j, 'x');
                }
            }
        }
        return moveable;
    }

}
