import java.lang.Math;

public enum UnaryOperations implements Operation {

    NEGATE("-", true) {
        public double apply(double ... operands) {
            assert operands.length == numberOfOperands;
            return -operands[0];
        }
    },
    SQUARED("^2", false) {
        public double apply(double ... operands) {
            assert operands.length == numberOfOperands;
            return operands[0] * operands[0];
        }
    },
    SQRT("_/", true) {
        public double apply(double ... operands) {
            assert operands.length == numberOfOperands;
            return Math.sqrt(operands[0]);
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
