public class Operations {

    public static Expression ADD(Evaluable e1, Evaluable e2) {
        return new Expression(BinaryOperations.ADD, e1, e2);
    }


    public static Expression MINUS(Evaluable e1, Evaluable e2) {
        return new Expression(BinaryOperations.MINUS, e1, e2);
    }

    public static Expression MULTIPLY(Evaluable e1, Evaluable e2) {
        return new Expression(BinaryOperations.MULTIPLY, e1, e2);
    }

    public static Expression DIVIDE(Evaluable e1, Evaluable e2) {
        return new Expression(BinaryOperations.DIVIDE, e1, e2);
    }

    public static Expression NEGATE(Evaluable e) {
        return new Expression(UnaryOperations.NEGATE, e);
    }

    public static Expression SQAURED(Evaluable e) {
        return new Expression(UnaryOperations.SQUARED, e);
    }

    public static Expression SQRT(Evaluable e) {
        return new Expression(UnaryOperations.SQRT, e);
    }
}
