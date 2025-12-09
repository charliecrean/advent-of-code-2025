package dev.crean.daysix;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CephalopodPartTwoCalculator {
    private final List<List<Character>> values = new ArrayList<>();

    public void addRow(String row) {
        values.add(IntStream.range(0, row.length()).mapToObj(row::charAt).collect(Collectors.toList()));
    }

    public Long calculate() {
        List<Character> operands = values.getLast();
        OptionalInt optionalMaxListSize = values.stream().mapToInt(List::size).max();
        int maxListSize = optionalMaxListSize.isPresent() ? optionalMaxListSize.getAsInt() : 0;

        Stack<Character> operandStack = new Stack<>();
        operands.stream().filter(it -> it != null && !it.equals(' ')).forEach(operandStack::push);

        List<CephalopodSum> sums = new ArrayList<>();

        Character currentOperand = operandStack.pop();
        CephalopodSum sum = new CephalopodSum(currentOperand);

        for (int i = maxListSize - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < values.size() - 1; j++) {
                List<Character> list = values.get(j);
                if (!(i > list.size() - 1)) {
                    Character curr = values.get(j).get(i);
                    if (!curr.equals(' ')) {
                        sb.append(curr);
                    }
                }
            }
            sum.addElement(sb.toString());

            if (i < operands.size() && operands.get(i).equals(currentOperand)) {
                sums.add(sum);

                if (!operandStack.isEmpty()) {
                    currentOperand = operandStack.pop();
                    sum = new CephalopodSum(currentOperand);
                    i--;
                }
            }
        }

        return sums.stream().mapToLong(CephalopodSum::calculate).sum();
    }
}
