import java.util.HashMap;

public class EvalVisitor implements NodeVisitor {

    public EvalVisitor() {
        this._result = new HashMap<>();
    }
    
    public void visitConstantNode(ConstantNode c) {
        this._result.put(c, c.getValue());
    }

    public void visitVariableNode(VariableNode v) throws UninitializedVariableException{
        try {
            this._result.put(v, v.getValue());
        } catch (UninitializedVariableException uve) {
            throw uve;
        }
    }

    public void visitUnaryNode(UnaryNode un) {
        double operand = this._result.get(un.getOperand());
        this._result.put(un, un.getOperation().apply(operand));
    }

    public void visitBinaryNode(BinaryNode bn) {
        double operandL = this._result.get(bn.getOperandL());
        double operandR = this._result.get(bn.getOperandR());
        this._result.put(bn, bn.getOperation().apply(operandL, operandR));
    }

    public double getResult(ExpressionNode e) {
        return this._result.get(e);
    }

    private HashMap<ExpressionNode, Double> _result;
}
