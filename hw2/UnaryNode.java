import java.lang.IllegalArgumentException;

public class UnaryNode implements ExpressionNode {

    private ArithmeticEnv _env = null;
    private UnaryOperation _operation = null;
    private ExpressionNode _operand = null;

    // does not allow empty computation node
    private UnaryNode() {};
    
    // constructor
    public UnaryNode(UnaryOperation operation, ExpressionNode operand) {
        this._env = operand.getEnv();
        this._operation = operation;
        this._operand = operand;
    }

    // accept method
    public void accept(NodeVisitor visitor) {
        this._operand.accept(visitor);
        visitor.visitUnaryNode(this);
    }

    @Override public String toString() {
        if (this._operation.writeSymbolFirst()) {
            return this._operation + "(" + this._operand + ")";
        } else {
            return  "(" + this._operand + ")" + this._operation;
        }
    }

    // get the operation
    /* Don't make your user cast */
    public UnaryOperation getOperation() {
        return this._operation;
    }

    // get operand
    public ExpressionNode getOperand() {
        return this._operand;
    }

    // get the associated environment
    public ArithmeticEnv getEnv() {
        return this._env;
    }
}
