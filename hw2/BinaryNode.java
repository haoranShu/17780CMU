public class BinaryNode implements ExpressionNode {

    private ArithmeticEnv _env = null;
    private BinaryOperation _operation = null;
    private ExpressionNode _operandL = null;
    private ExpressionNode _operandR = null;

    // does not allow empty computation node    
    private BinaryNode() {}

    // constructor
    public BinaryNode(BinaryOperation operation, ExpressionNode operandL, ExpressionNode operandR) {
        assert operandL.getEnv().equals(operandR.getEnv()) : "Both operands must belong to the same Arithmetic Environment.";
        this._env = operandL.getEnv();
        this._operation = operation;
        this._operandL = operandL;
        this._operandR = operandR;
    }

    // accept method
    public void accept(NodeVisitor visitor) {
        this._operandL.accept(visitor);
        this._operandR.accept(visitor);
        visitor.visitBinaryNode(this);
    }

    @Override public String toString() {
        return "(" + this._operandL + ")" + this._operation + "(" + this._operandR + ")";
    }

    // get the operation
    /* Don't make your user cast */
    public BinaryOperation getOperation() {
        return this._operation;
    }

    // get left operand
    public ExpressionNode getOperandL() {
        return this._operandL;
    }

    // get right operand
    public ExpressionNode getOperandR() {
        return this._operandR;
    }

    // get associated environment
    public ArithmeticEnv getEnv() {
        return this._env;
    }
}
