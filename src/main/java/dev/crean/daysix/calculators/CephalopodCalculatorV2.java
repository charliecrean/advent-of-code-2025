package dev.crean.daysix.calculators;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CephalopodCalculatorV2 implements CephalopodCalculator {
    private final List<List<Character>> values = new ArrayList<>();

    @Override
    public void addRow(String row) {
        values.add(IntStream.range(0, row.length())
                .mapToObj(row::charAt)
                .collect(Collectors.toList()));
    }

    @Override
    public Long calculate() {
        List<Character> operands = values.getLast();
        Stack<Character> operandStack = convertToOperandStack(operands);
        int maxListSize = getMaxListSize();

        List<CephalopodSum> sums = new ArrayList<>();

        Character currentOperand = operandStack.pop();
        CephalopodSum sum = new CephalopodSum(currentOperand);

        for (int i = maxListSize - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();

            int finalI = i;
            IntStream.range(0, values.size() - 1)
                    .mapToObj(values::get)
                    .filter(it -> it.size() > finalI)
                    .map(it -> it.get(finalI))
                    .filter(c -> !c.equals(' '))
                    .forEach(sb::append);

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

    private int getMaxListSize() {
        OptionalInt optionalMaxListSize = values.stream().mapToInt(List::size).max();
        return optionalMaxListSize.isPresent() ? optionalMaxListSize.getAsInt() : 0;
    }

    private Stack<Character> convertToOperandStack(List<Character> list) {
        Stack<Character> stack = new Stack<>();
        list.stream().filter(it -> it != null && !it.equals(' ')).forEach(stack::push);
        return stack;
    }
}
