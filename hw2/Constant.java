public class Constant implements Evaluable {

    private final double value;
    private final String name;

    public Constant(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public double getValue() {
        return this.value;
    }

    public double eval() {
        return this.getValue();
    }

    @Override public String toString() {
        return String.valueOf(this.value);
    }
}
