public interface NodeVisitor {

    public void visitConstantNode(ConstantNode c);

    public void visitVariableNode(VariableNode v);

    public void visitUnaryNode(UnaryNode un);

    public void visitBinaryNode(BinaryNode bn);
}
