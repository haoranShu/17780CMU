public class Operations {

    public static Expression ADD(Evaluable e1, Evaluable e2) {
        return new Expression(BinaryOperations.ADD, e1, e2);
    }

}
