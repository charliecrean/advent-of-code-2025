package dev.crean.dayfour;

class FirstMatchMoveableCounter extends MoveableCounter {

    @Override
    public int getMoveableRollCount() {
        int moveable = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (originalGrid.get(i).get(j) == '@' && totals[i][j] < 4) {
                    moveable++;
                }
            }
        }
        return moveable;
    }

}
