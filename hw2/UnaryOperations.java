import java.lang.Math;

public enum UnaryOperations implements Operation {

    NEGATE("-", true) {
        public double apply(Evaluable ... operands) {
            assert operands.length == numberOfOperands;
            return -operands[0].eval();
        }
    },
    SQUARED("^2", false) {
        public double apply(Evaluable ... operands) {
            assert operands.length == numberOfOperands;
            return operands[0].eval() * operands[0].eval();
        }
    },
    SQRT("_/", true) {
        public double apply(Evaluable ... operands) {
            assert operands.length == numberOfOperands;
            return Math.sqrt(operands[0].eval());
        }
    };

    private static final int numberOfOperands = 1;

    private final String symbol;
    private final boolean writtenFirst;

    UnaryOperations(String symbol, boolean writtenFirst) {
        this.symbol = symbol;
        this.writtenFirst = writtenFirst;
    }

    public int getNumberOfOperands() {
        return numberOfOperands;
    }

    public boolean writeSymbolFirst() {
        return this.writtenFirst;
    }

    @Override public String toString() {
        return this.symbol;
    }
}
