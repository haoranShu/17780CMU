import java.util.HashSet;

public class SetOfVariableVisitor implements NodeVisitor {
    private HashSet<VariableNode> _variables;

    public SetOfVariableVisitor() {
        this._variables = new HashSet<>();
    }

    public void visitConstantNode(ConstantNode c) { return; }

    public void visitVariableNode(VariableNode v) {
        this._variables.add(v);
    }

    public void visitUnaryNode(UnaryNode un) { return; }

    public void visitBinaryNode(BinaryNode bn) { return; }

    public HashSet<VariableNode> getVariables() {
        return this._variables;
    }
}
