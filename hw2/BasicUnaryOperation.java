import java.lang.Math;

public enum BasicUnaryOperation implements UnaryOperation {
    /**
     * This enum class defines basic unary operations
     */

    NEGATE("-", true) {
        public double apply(double operand) {
            return -operand;
        }
    },
    SQUARED("^2", false) {
        public double apply(double operand) {
            return operand * operand;
        }
    },
    SQRT("_/", true) {
        public double apply(double operand) {
            return Math.sqrt(operand);
        }
    };

    private final String _symbol;
    private final boolean _writtenFirst;

    BasicUnaryOperation(String symbol, boolean writtenFirst) {
        this._symbol = symbol;
        this._writtenFirst = writtenFirst;
    }

    public boolean writeSymbolFirst() {
        return this._writtenFirst;
    }

    @Override public String toString() {
        return this._symbol;
    }
}
