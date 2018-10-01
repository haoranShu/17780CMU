public class Usecase {
    public static void main(String[] args) {
        Constant c = new Constant("c", 1.0);
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Expression e = Operations.ADD(x, y);
        Expression e2 = new Expression(BinaryOperations.MINUS, e, c);
        x.setValue(1.2);
        y.setValue(1.2);
        double z = e.eval();
        System.out.println(z);
    }
}
