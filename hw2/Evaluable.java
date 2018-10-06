public interface Evaluable {
    public double eval() throws UninitializedVariableException;

    public void accept(NodeVisitor visitor);
}
