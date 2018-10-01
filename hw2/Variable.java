public class Variable implements Evaluable {

    private double value;
    private boolean initialized;
    private String name;

    public Variable(String name) {
        this.name = name;
        this.initialized = false;
    }

    public Variable(String name, double value) {
        this.name = name;
        this.initialized = true;
        this.value = value;
    } 

    public double getValue() throws UninitializedVariableException {
        if (this.initialized) {
            return this.value;
        } else {
            throw new UninitializedVariableException(this.name + " is not initialized.");
        }
    }

    public void setValue(double value) {
        this.value = value;
        this.initialized = true;
    }

    public double eval() throws UninitializedVariableException {
        try {
            return this.getValue();
        } catch (UninitializedVariableException uve) {
            throw uve;
        }
    }
}
