import java.lang.IllegalArgumentException;

public class Expression implements Evaluable {

    private Operation operation;
    private Evaluable[] operands;
    
    public Expression(Operation operation, Evaluable ... operands)
            throws IllegalArgumentException {
        this.operation = operation;
        if (operation.getNumberOfOperands() != operands.length) {
            throw new IllegalArgumentException(operation + " expects " +
                    operation.getNumberOfOperands() + " operands but got " +
                    operands.length);
        }
        this.operands = operands;
    }

    public double eval() throws UninitializedVariableException {
        try {
            return this.operation.apply(this.operands);
        } catch (UninitializedVariableException uve) {
            throw uve;
        }
    }
}
