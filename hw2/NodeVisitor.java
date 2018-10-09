/**
 * NodeVisitor.java
 * Defines the interface for visitors that operate on ExpressionNodes
 */

public interface NodeVisitor {

    // Visit method for Cosntants
    public void visitConstantNode(ConstantNode c);

    // Visit method for Variables
    public void visitVariableNode(VariableNode v);

    // Visit method for Unary Computation Nodes
    public void visitUnaryNode(UnaryNode un);

    // Visit method for Binary Computation Nodes
    public void visitBinaryNode(BinaryNode bn);
}
