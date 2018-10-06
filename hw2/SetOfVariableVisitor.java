import java.util.HashSet;

public class SetOfVariableVisitor implements NodeVisitor {
    private HashSet<Variable> variables;

    public SetOfVariableVisitor() {
        this.variables = new HashSet<>();
    }

    public void visitConstant(Constant c) { return; }

    public void visitVariable(Variable v) {
        this.variables.add(v);
    }

    public void visitExpression(Expression e) { return; }

    public HashSet<Variable> getVariables() {
        return this.variables;
    }
}
