import java.util.HashMap;
import java.lang.IllegalStateException;

public class LispVisitor implements NodeVisitor {

    public LispVisitor() {
        this._result = new HashMap<>();
        this._mostRecentVisited = null;
    }
    
    public void visitConstantNode(ConstantNode c) {
        this._result.put(c, String.valueOf(c.getValue()));
        this._mostRecentVisited = c;
    }

    public void visitVariableNode(VariableNode v) {
        this._result.put(v, v.getName());
        this._mostRecentVisited = v;
    }

    public void visitUnaryNode(UnaryNode un) {
        String operand = this._result.get(un.getOperand());
        String s = "(" + un.getOperation() + " " + operand + ")";
        this._result.put(un, s);
        this._mostRecentVisited = un;
    }

    public void visitBinaryNode(BinaryNode bn) {
        String operandL = this._result.get(bn.getOperandL());
        String operandR = this._result.get(bn.getOperandR());
        String s = "(" + bn.getOperation() + " " + operandL + " " + operandR + ")";
        this._result.put(bn, s);
        this._mostRecentVisited = bn;
    }

    public String getResult() {
        if (this._mostRecentVisited != null) {
            return this._result.get(this._mostRecentVisited);
        } else {
            throw new IllegalStateException("No result available.");
        }
    }

    private HashMap<ExpressionNode, String> _result;
    private ExpressionNode _mostRecentVisited;
}
