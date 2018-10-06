public class Usecase {
    public static void main(String[] args) {
        Constant c = new Constant("c", 1.0);
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Expression e1 = Operations.ADD(x, y);
        Expression e2 = Operations.MINUS(e1, c);
        Expression e3 = Operations.MULTIPLY(e2, y);
        Expression e4 = Operations.NEGATE(e3);
        Expression e5 = Operations.SQRT(e2);
        x.setValue(1.2);
        y.setValue(1.2);
        double z = e3.eval();
        System.out.println(z);
        System.out.println(e3);
        double w = e4.eval();
        System.out.println(w);
        System.out.println(e4);
        double h = e5.eval();
        System.out.println(h);
        System.out.println(e5);

        SetOfVariableVisitor svv = new SetOfVariableVisitor();
        e1.accept(svv);
        System.out.println(svv.getVariables());
    }
}
