public class VariableNode implements ExpressionNode {

    private final ArithmeticEnv _env;
    private double _value;
    private boolean _initialized;
    private final String _name;

    public VariableNode(ArithmeticEnv env, String name) {
        this._env = env;
        this._name = name;
        this._initialized = false;
    }

    public VariableNode(ArithmeticEnv env, String name, double value) {
        this._env = env;
        this._name = name;
        this._initialized = true;
        this._value = value;
    } 

    public double getValue() {
        if (this._initialized) {
            return this._value;
        } else {
            throw new UninitializedVariableException(this._name + " is not initialized.");
        }
    }

    public void setValue(double value) {
        this._value = value;
        this._initialized = true;
    }

    public String getName() {
        return this._name;
    }

    public boolean initialized() {
        return this._initialized;
    }

    public ArithmeticEnv getEnv() {
        return this._env;
    }

    public void accept(NodeVisitor visitor) {
        visitor.visitVariableNode(this);
    }

    @Override public String toString() {
        return this._name;
    }
}
