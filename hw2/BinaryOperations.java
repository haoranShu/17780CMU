public enum BinaryOperations implements Operation {

    ADD("+") {
        public double apply(Evaluable ... operands) {
            assert operands.length == numberOfOperands;
            return operands[0].eval() + operands[1].eval();
        }
    },
    MINUS("-") {
        public double apply(Evaluable ... operands) {
            assert operands.length == numberOfOperands;
            return operands[0].eval() - operands[1].eval();
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
}
