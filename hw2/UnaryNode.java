import java.lang.IllegalArgumentException;

public class UnaryNode implements ExpressionNode {

    private final ArithmeticEnv _env;
    private final UnaryOperation _operation;
    private final ExpressionNode _operand;
    
    public UnaryNode(UnaryOperation operation, ExpressionNode operand) {
        this._env = operand.getEnv();
        this._operation = operation;
        this._operand = operand;
    }

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

    /* Don't make your user cast */
    public UnaryOperation getOperation() {
        return this._operation;
    }

    public ExpressionNode getOperand() {
        return this._operand;
    }

    public ArithmeticEnv getEnv() {
        return this._env;
    }
}
