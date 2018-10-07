public class Usecase {
    public static void main(String[] args) {
        ArithmeticEnv testenv = ArithmeticEnv.getEnvironment();

        ConstantNode c = testenv.createConstant("c", 1.0);
        VariableNode x = testenv.createVariable("x");
        VariableNode y = testenv.createVariable("y");
        VariableNode l = testenv.createVariable("l");
        ExpressionNode e1 = testenv.ADD(x, y);
        ExpressionNode e2 = testenv.MINUS(e1, c);
        ExpressionNode e3 = testenv.MULTIPLY(e2, y);
        ExpressionNode e4 = testenv.NEGATE(e3);
        ExpressionNode e5 = testenv.SQRT(e2);
        x.setValue(1.2);
        y.setValue(1.2);
        EvalVisitor evz = new EvalVisitor();
        double z = e3.accept(evz).getResult();
        System.out.println(z);
        System.out.println(e3);
        EvalVisitor evw = new EvalVisitor();
        double w = e4.accept(evw).getResult();
        System.out.println(w);
        System.out.println(e4);
        EvalVisitor evh = new EvalVisitor();
        double h = e5.accept(evh).getResult();
        System.out.println(h);
        System.out.println(e5);

        SetOfVariableVisitor svv = new SetOfVariableVisitor();
        e1.accept(svv);
        System.out.println(svv.getVariables());

        testenv.printOverview();
    }
}
