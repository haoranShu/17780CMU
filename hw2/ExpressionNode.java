public interface ExpressionNode {
    public void accept(NodeVisitor visitor);

    public ArithmeticEnv getEnv();
}
