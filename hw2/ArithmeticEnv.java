import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.lang.IllegalArgumentException;

public class ArithmeticEnv {

    private HashMap<String, ConstantNode> _constants;
    private HashMap<String, VariableNode> _variables;
    private HashSet<UnaryNode> _unarynodes;
    private HashSet<BinaryNode> _binarynodes;

    private ArithmeticEnv() {
        this._constants = new HashMap<>();
        this._variables = new HashMap<>();
        this._unarynodes = new HashSet<>();
        this._binarynodes = new HashSet<>();
    }

    public static ArithmeticEnv getEnvironment() {
        return new ArithmeticEnv();
    }

    public VariableNode createVariable(String name) throws IllegalArgumentException {
        if (this._variables.containsKey(name)) {
            throw new IllegalArgumentException("Variable name " + name + " has already existed in this environment.");
        } else {
            VariableNode var = new VariableNode(this, name);
            this._variables.put(name, var);
            return var;
        }
    }

    public VariableNode createVariable(String name, double value) {
        if (this._variables.containsKey(name)) {
            throw new IllegalArgumentException("Variable name " + name + " has already existed in this environment.");
        } else {
            VariableNode var = new VariableNode(this, name, value);
            this._variables.put(name, var);
            return var;
        }
    }

    public ConstantNode createConstant(String name, double value) {
        if (this._constants.containsKey(name)) {
            throw new IllegalArgumentException("Constant name " + name + " has already existed in this environment.");
        } else {
            ConstantNode c = new ConstantNode(this, name, value);
            this._constants.put(name, c);
            return c;
        }
    }

    public boolean containsVariable(VariableNode vn) {
        return vn.equals(this._variables.get(vn.getName()));
    }

    public boolean containsConstant(ConstantNode cn) {
        return cn.equals(this._constants.get(cn.getName()));
    }

    public boolean containsNode(BinaryNode bn) {
        return this.equals(bn.getEnv());
    }

    public boolean containsNode(UnaryNode un) {
        return this.equals(un.getEnv());
    }

    public Optional<VariableNode> getVariable(String name) {
        return Optional.ofNullable(this._variables.get(name));
    }

    public Optional<ConstantNode> getConstant(String name) {
        return Optional.ofNullable(this._constants.get(name));
    }

    public BinaryNode ADD(ExpressionNode e1, ExpressionNode e2) {
        BinaryNode bn = new BinaryNode(BasicBinaryOperation.ADD, e1, e2);
        this._binarynodes.add(bn);
        return bn;
    }

    public BinaryNode MINUS(ExpressionNode e1, ExpressionNode e2) {
        BinaryNode bn = new BinaryNode(BasicBinaryOperation.MINUS, e1, e2);
        this._binarynodes.add(bn);
        return bn;
    }

    public BinaryNode MULTIPLY(ExpressionNode e1, ExpressionNode e2) {
        BinaryNode bn = new BinaryNode(BasicBinaryOperation.MULTIPLY, e1, e2);
        this._binarynodes.add(bn);
        return bn;
    }

    public BinaryNode DIVIDE(ExpressionNode e1, ExpressionNode e2) {
        BinaryNode bn = new BinaryNode(BasicBinaryOperation.DIVIDE, e1, e2);
        this._binarynodes.add(bn);
        return bn;
    }

    public UnaryNode NEGATE(ExpressionNode e) {
        UnaryNode un = new UnaryNode(BasicUnaryOperation.NEGATE, e);
        this._unarynodes.add(un);
        return un;
    }

    public UnaryNode SQUARED(ExpressionNode e) {
        UnaryNode un = new UnaryNode(BasicUnaryOperation.SQUARED, e);
        this._unarynodes.add(un);
        return un;
    }

    public UnaryNode SQRT(ExpressionNode e) {
        UnaryNode un = new UnaryNode(BasicUnaryOperation.SQRT, e);
        this._unarynodes.add(un);
        return un;
    }

    public void printOverview() {
        String s = "------------------------\n";
        s += "Environment Overview:\n";
        s += "Variables\n";
        for (VariableNode var : this._variables.values()) {
            s += var.getName() + "    " + (var.initialized() ? var.getValue() : "?") + "\n";
        }
        s += "Constants\n";
        for (ConstantNode c : this._constants.values()) {
            s += c.getName() + "    " + c.getValue() + "\n";
        }
        s += "Expressions\n";
        for (UnaryNode un : this._unarynodes) {
            s += un.toString() + "\n";
        }
        for (BinaryNode bn : this._binarynodes) {
            s += bn.toString() + "\n";
        }
        s += "------------------------";
        System.out.println(s);
    }
}
