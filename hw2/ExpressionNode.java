/**
 * ExpressionNode.java
 * Defines an interface for main arithmetic components.
 */

public interface ExpressionNode {

    // accept the visit of node visitors
    public void accept(NodeVisitor visitor);

    // returns the associated arithmetic environment
    public ArithmeticEnv getEnv();
}
