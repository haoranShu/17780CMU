public interface Operation {
    public int getNumberOfOperands();

    public double apply(Evaluable ... operands);
}
