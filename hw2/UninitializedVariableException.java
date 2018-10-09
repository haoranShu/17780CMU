public class UninitializedVariableException extends RuntimeException {
    /*
     * This class defines a runtime exception that must be thrown
     * when an uninitialized VariableNode gets evaluated in any way.
     */

    // constructor
    public UninitializedVariableException(String s) {
        super(s);
    }
}
