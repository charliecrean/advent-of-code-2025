package dev.crean.dayfour;

class FirstMatchMoveableCounter extends MoveableCounter {

    @Override
    public int getMoveableRollCount() {
        int moveable = 0;
        for (int i = 0; i < originalGrid.size(); i++) {
            for (int j = 0; j < originalGrid.getFirst().size(); j++) {
                if (originalGrid.get(i).get(j) == '@' && totals[i][j] < 4) {
                    moveable++;
                }
            }
        }
        return moveable;
    }

}
