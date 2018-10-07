import java.lang.IllegalArgumentException;

public class Simpsons {
    public static double integrate(ExpressionNode en, VariableNode var, double start, double end, int N)
            throws IllegalArgumentException {
        if (N%2 == 1) {
            throw new IllegalArgumentException("N must be even.");
        }
        double delta = (end - start) / N;
        EvalVisitor evaluator = new EvalVisitor();
        double accumulator = 0.0;
        for (int i = 0; i <= N; ++i) {
            var.setValue(start + i * delta);
            en.accept(evaluator);
            double evali = evaluator.getResult(en);
            if (i == 0 || i == N) {
                accumulator += evali;
            } else if (i%2 == 1) {
                accumulator += evali * 4;
            } else {
                accumulator += evali * 2;
            }
        }
        return accumulator * delta / 3.0;
    }

    public static void main(String[] args) {
        ArithmeticEnv env = ArithmeticEnv.getEnvironment();

        VariableNode x = env.createVariable("x");
        ExpressionNode sq = env.ADD(env.SQUARED(x), x);

        System.out.println(integrate(sq, x, 0.0, 1.0, 10));
    }
}
