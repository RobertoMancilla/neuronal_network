package neuronal_network;

public abstract class AbstractNeuron {
    @Override
    public abstract String toString();
    public abstract void mutate(Double learnFactor);
    public abstract void forget();
    public abstract void remember();
    public abstract double compute(double input1, double input2);
}
