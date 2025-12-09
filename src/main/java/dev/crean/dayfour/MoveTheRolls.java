package dev.crean.dayfour;

import dev.crean.dayfour.counter.MoveableRollCounter;
import dev.crean.utils.FileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MoveTheRolls {

    private final String path;
    private final MoveableRollCounter counter;

    public MoveTheRolls(String path, MoveableRollCounter counter) {
        this.path = path;
        this.counter = counter;
    }

    public int findMoveableRollCount() {
        return new RollGrid(getInputs(path), counter).compute();
    }

    private List<List<Character>> getInputs(String path) {
        FileHandler<List<Character>> parser = new FileHandler<>(path);
        List<List<Character>> inputs = new ArrayList<>();
        parser.processFileLines(this::parseRolls, inputs::add);
        return inputs;
    }

    private List<Character> parseRolls(String input) {
        return input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }
}

