public enum BasicBinaryOperation implements BinaryOperation {

    ADD("+") {
        public double apply(double operandL, double operandR) {
            return operandL + operandR;
        }
    },
    MINUS("-") {
        public double apply(double operandL, double operandR) {
            return operandL - operandR;
        }
    },
    MULTIPLY("*") {
        public double apply(double operandL, double operandR) {
            return operandL * operandR;
        }
    },
    DIVIDE("/") {
        public double apply(double operandL, double operandR) {
            return operandL / operandR;
        }
    };

    private final String _symbol;

    BasicBinaryOperation(String symbol) {
        this._symbol = symbol;
    }

    @Override public String toString() {
        return this._symbol;
    }
}
