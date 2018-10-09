import java.util.HashMap;
import java.lang.IllegalStateException;

public class EvalVisitor implements NodeVisitor {
    /**
     * The evaluation visitor
     */

    // constructor
    public EvalVisitor() {
        this._result = new HashMap<>();
        this._mostRecentVisited = null;
    }
    
    // puts constant value for evaluating constants
    public void visitConstantNode(ConstantNode c) {
        this._result.put(c, c.getValue());
        this._mostRecentVisited = c;
    }

    // puts associated value, if any, for variables 
    public void visitVariableNode(VariableNode v) {
        this._result.put(v, v.getValue());
        this._mostRecentVisited = v;
    }

    // evaluate based on operation
    public void visitUnaryNode(UnaryNode un) {
        double operand = this._result.get(un.getOperand());
        this._result.put(un, un.getOperation().apply(operand));
        this._mostRecentVisited = un;
    }

    // evaluate based on operation
    public void visitBinaryNode(BinaryNode bn) {
        double operandL = this._result.get(bn.getOperandL());
        double operandR = this._result.get(bn.getOperandR());
        this._result.put(bn, bn.getOperation().apply(operandL, operandR));
        this._mostRecentVisited = bn;
    }

    // order of visits guaranteed by the accept method implementation
    // get result returns the most recent evalutated result
    public double getResult() {
        if (this._mostRecentVisited != null) {
            return this._result.get(this._mostRecentVisited);
        } else {
            throw new IllegalStateException("No result available.");
        }
    }

    private HashMap<ExpressionNode, Double> _result;
    private ExpressionNode _mostRecentVisited;
}
