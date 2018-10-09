public class ConstantNode implements ExpressionNode {

    private ArithmeticEnv _env = null;
    private double _value = 0;
    private String _name = null;

    // does not allow empty node
    private ConstantNode() {};

    // constructor
    public ConstantNode(ArithmeticEnv env, String name, double value) {
        this._env = env;
        this._name = name;
        this._value = value;
    }

    // returns the name of constant
    public String getName() {
        return this._name;
    }

    // returns the value of constant
    public double getValue() {
        return this._value;
    }

    // get the associated environment
    public ArithmeticEnv getEnv() {
        return this._env;
    }

    // accept method
    public void accept(NodeVisitor visitor) {
        visitor.visitConstantNode(this);
    }

    @Override public String toString() {
        return String.valueOf(this._value);
    }
}
