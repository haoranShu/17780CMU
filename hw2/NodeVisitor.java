public interface NodeVisitor {

    public void visitConstant(Constant c);

    public void visitVariable(Variable v);

    public void visitExpression(Expression e);
}
