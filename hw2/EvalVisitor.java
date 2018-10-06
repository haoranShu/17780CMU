import java.util.HashMap;

public class EvalVisitor implements NodeVisitor {

    public EvalVisitor() {
        this.result = new HashMap<>();
    }
    
    public void visitConstant(Constant c) {
        this.result.put(c, c.getValue());
    }

    public void visitVariable(Variable v) {
        try {
            this.result.put(v, v.getValue());
        } catch (UninitializedVariableException uve) {
            System.out.println(uve.getMessage());
        }
    }

    public void visitExpression(Expression e) {
        double[] operandValues = new double[e.getOperation().getNumberOfOperands()];
        Evaluable[] operands = e.getOperands();
        for (int i = 0; i < operands.length; ++i) {
            operandValues[i] = this.result.get(operands[i]);
        }
        this.result.put(e, e.getOperation().apply(operandValues));
    }

    public double getResult(Evaluable e) {
        return this.result.get(e);
    }

    private HashMap<Evaluable, Double> result;
}
