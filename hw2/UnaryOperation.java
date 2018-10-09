/**
 * UnaryOperation.java
 * Defines the interface for unary mathematical operations
 */

public interface UnaryOperation {

    // returns the result of operation applied on given operand
    public double apply(double operand);

    // returns if the symbol is written ahead of operand
    // for purpose of formatted printing
    public boolean writeSymbolFirst();
}
