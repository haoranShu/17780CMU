public class ConstantNode implements ExpressionNode {

    private ArithmeticEnv _env = null;
    private double _value = 0;
    private String _name = null;

    private ConstantNode() {};

    public ConstantNode(ArithmeticEnv env, String name, double value) {
        this._env = env;
        this._name = name;
        this._value = value;
    }

    public String getName() {
        return this._name;
    }

    public double getValue() {
        return this._value;
    }

    public ArithmeticEnv getEnv() {
        return this._env;
    }

    public void accept(NodeVisitor visitor) {
        visitor.visitConstantNode(this);
    }

    @Override public String toString() {
        return String.valueOf(this._value);
    }
}
