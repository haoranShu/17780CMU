import java.util.HashMap;
import java.lang.IllegalStateException;
import java.util.Optional;

public class EvalVisitor implements NodeVisitor {

    public EvalVisitor() {
        this._result = new HashMap<>();
        this._mostRecentVisited = null;
    }
    
    public void visitConstantNode(ConstantNode c) {
        this._result.put(c, c.getValue());
        this._mostRecentVisited = c;
    }

    public void visitVariableNode(VariableNode v) {
        this._result.put(v, v.getValue());
        this._mostRecentVisited = v;
    }

    public void visitUnaryNode(UnaryNode un) {
        double operand = this._result.get(un.getOperand());
        this._result.put(un, un.getOperation().apply(operand));
        this._mostRecentVisited = un;
    }

    public void visitBinaryNode(BinaryNode bn) {
        double operandL = this._result.get(bn.getOperandL());
        double operandR = this._result.get(bn.getOperandR());
        this._result.put(bn, bn.getOperation().apply(operandL, operandR));
        this._mostRecentVisited = bn;
    }

    public double getResult() {
        if (this._mostRecentVisited != null) {
            return this._result.get(this._mostRecentVisited);
        } else {
            throw new IllegalStateException("No result available.");
        }
    }

    public Optional<Double> getResult(ExpressionNode e) {
        return Optional.ofNullable(this._result.get(e));
    }

    private HashMap<ExpressionNode, Double> _result;
    private ExpressionNode _mostRecentVisited;
}
