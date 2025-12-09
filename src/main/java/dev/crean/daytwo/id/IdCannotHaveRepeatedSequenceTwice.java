package dev.crean.daytwo.id;

class IdCannotHaveRepeatedSequenceTwice implements IdVerificationRule {

    public IdCannotHaveRepeatedSequenceTwice() {}

    @Override
    public boolean isValid(long id) {
        String idString = Long.toString(id);

        if (idString.length() % 2 != 0) {
            return true;
        }

        int midIndex = idString.length() / 2;
        String firstHalf = idString.substring(0, midIndex);
        String secondHalf = idString.substring(midIndex);

        return !firstHalf.equals(secondHalf);
    }
}
