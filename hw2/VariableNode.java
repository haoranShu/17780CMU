public class VariableNode implements ExpressionNode {

    private ArithmeticEnv _env = null;
    private double _value = 0;
    private boolean _initialized = false;
    private String _name = null;

    // does not allow empty variable
    private VariableNode() {};

    // constructor
    public VariableNode(ArithmeticEnv env, String name) {
        this._env = env;
        this._name = name;
        this._initialized = false;
    }

    // constructor
    public VariableNode(ArithmeticEnv env, String name, double value) {
        this._env = env;
        this._name = name;
        this._initialized = true;
        this._value = value;
    } 

    // get associated value if any
    public double getValue() {
        if (this._initialized) {
            return this._value;
        } else {
            throw new UninitializedVariableException(this._name + " is not initialized.");
        }
    }

    // set the value for this variable
    public void setValue(double value) {
        this._value = value;
        this._initialized = true;
    }

    // get name
    public String getName() {
        return this._name;
    }

    // get if initialized
    public boolean initialized() {
        return this._initialized;
    }

    // get the associated arithmetic environment
    public ArithmeticEnv getEnv() {
        return this._env;
    }

    // accept method
    public void accept(NodeVisitor visitor) {
        visitor.visitVariableNode(this);
    }

    @Override public String toString() {
        return this._name;
    }
}
