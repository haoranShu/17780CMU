import java.lang.Math;

public enum UnaryOperations implements Operation {

    NEGATE("-") {
        public double apply(Evaluable ... operands) {
            assert operands.length == numberOfOperands;
            return -operands[0].eval();
        }
    },
    SQUARED("^2") {
        public double apply(Evaluable ... operands) {
            assert operands.length == numberOfOperands;
            return operands[0].eval() * operands[0].eval();
        }
    },
    SQRT("^/2") {
        public double apply(Evaluable ... operands) {
            assert operands.length == numberOfOperands;
            return Math.sqrt(operands[0].eval());
        }
    };

    private static final int numberOfOperands = 1;

    private final String symbol;

    UnaryOperations(String symbol) {
        this.symbol = symbol;
    }

    public int getNumberOfOperands() {
        return numberOfOperands;
    }
}
