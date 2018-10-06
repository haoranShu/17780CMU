public enum BinaryOperations implements Operation {

    ADD("+") {
        public double apply(double ... operands) {
            assert operands.length == numberOfOperands;
            return operands[0] + operands[1];
        }
    },
    MINUS("-") {
        public double apply(double ... operands) {
            assert operands.length == numberOfOperands;
            return operands[0] - operands[1];
        }
    },
    MULTIPLY("*") {
        public double apply(double ... operands) {
            assert operands.length == numberOfOperands;
            return operands[0] * operands[1];
        }
    },
    DIVIDE("/") {
        public double apply(double ... operands) {
            assert operands.length == numberOfOperands;
            return operands[0] / operands[1];
        }
    };

    private static final int numberOfOperands = 2;

    private final String symbol;

    BinaryOperations(String symbol) {
        this.symbol = symbol;
    }

    public int getNumberOfOperands() {
        return numberOfOperands;
    }

    @Override public String toString() {
        return this.symbol;
    }
}
