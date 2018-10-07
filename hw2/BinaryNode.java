public class BinaryNode implements ExpressionNode {

    private final ArithmeticEnv _env;
    private final BinaryOperation _operation;
    private final ExpressionNode _operandL;
    private final ExpressionNode _operandR;
    
    public BinaryNode(BinaryOperation operation, ExpressionNode operandL, ExpressionNode operandR) {
        assert operandL.getEnv().equals(operandR.getEnv()) : "Both operands must belong to the same Arithmetic Environment.";
        this._env = operandL.getEnv();
        this._operation = operation;
        this._operandL = operandL;
        this._operandR = operandR;
    }

    public void accept(NodeVisitor visitor) {
        this._operandL.accept(visitor);
        this._operandR.accept(visitor);
        visitor.visitBinaryNode(this);
    }

    @Override public String toString() {
        return "(" + this._operandL + ")" + this._operation + "(" + this._operandR + ")";
    }

    /* Don't make your user cast */
    public BinaryOperation getOperation() {
        return this._operation;
    }

    public ExpressionNode getOperandL() {
        return this._operandL;
    }

    public ExpressionNode getOperandR() {
        return this._operandR;
    }

    public ArithmeticEnv getEnv() {
        return this._env;
    }
}
