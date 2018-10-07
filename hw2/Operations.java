public class Operations {

    public static BinaryNode ADD(ExpressionNode e1, ExpressionNode e2) {
        return new BinaryNode(BasicBinaryOperation.ADD, e1, e2);
    }


    public static BinaryNode MINUS(ExpressionNode e1, ExpressionNode e2) {
        return new BinaryNode(BasicBinaryOperation.MINUS, e1, e2);
    }

    public static BinaryNode MULTIPLY(ExpressionNode e1, ExpressionNode e2) {
        return new BinaryNode(BasicBinaryOperation.MULTIPLY, e1, e2);
    }

    public static BinaryNode DIVIDE(ExpressionNode e1, ExpressionNode e2) {
        return new BinaryNode(BasicBinaryOperation.DIVIDE, e1, e2);
    }

    public static UnaryNode NEGATE(ExpressionNode e) {
        return new UnaryNode(BasicUnaryOperation.NEGATE, e);
    }

    public static UnaryNode SQAURED(ExpressionNode e) {
        return new UnaryNode(BasicUnaryOperation.SQUARED, e);
    }

    public static UnaryNode SQRT(ExpressionNode e) {
        return new UnaryNode(BasicUnaryOperation.SQRT, e);
    }
}
