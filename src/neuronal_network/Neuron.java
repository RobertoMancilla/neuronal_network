package neuronal_network;

import java.util.Random;

public class Neuron extends AbstractNeuron {
    Random random = new Random();

    private Double oldBias = random.nextDouble(-1, 1);
    private Double oldWeight1 = random.nextDouble(-1, 1);
    private Double oldWeight2 = random.nextDouble(-1, 1);

    private Double bias = random.nextDouble(-1, 1);
    private Double weight1 = random.nextDouble(-1, 1);
    private Double weight2 = random.nextDouble(-1, 1);

    public void mutate(Double learnFactor){
        int propertyToChange = random.nextInt(0, 3); //Se crean 3 numero aleatorios para las propiedades de bias, weight1 y weight2
        Double changeFactor = (learnFactor == null) ? random.nextDouble(-1, 1) : (learnFactor * random.nextDouble(-1, 1));
        if (propertyToChange == 0){
            this.bias += changeFactor;
        } else if (propertyToChange == 1){
            this.weight1 += changeFactor;
        } else {
            this.weight2 += changeFactor;
        }
    }
    public void forget(){
        bias = oldBias;
        weight1 = oldWeight1;
        weight2 = oldWeight2;
    }
    public void remember(){
        oldBias = bias;
        oldWeight1 = weight1;
        oldWeight2 = weight2;
    }
    public double compute(double input1, double input2){
        double preActivation = (this.weight1 * input1) + (this.weight2 * input2) + this.bias;
        double output = Util.sigmoid(preActivation);
        return output;
    }

    public Double getBias() {
        return bias;
    }

    public void setBias(Double bias) {
        this.bias = bias;
    }

    public Double getWeight1() {
        return weight1;
    }

    public void setWeight1(Double weight1) {
        this.weight1 = weight1;
    }

    public Double getWeight2() {
        return weight2;
    }

    public void setWeight2(Double weight2) {this.weight2 = weight2;}

    public String toString(){
        return String.format("oldBias: %.15f | bias: %.15f | oldWeight1: %.15f | weight1: %.15f | oldWeight2: %.15f | weight2: %.15f",
                this.oldBias, this.bias, this.oldWeight1, this.weight1, this.oldWeight2, this.weight2);
    }

    //----------------------------------------------------------------------------------

    public Double getOldBias() {
        return oldBias;
    }

    public void setOldBias(Double bias) {
        this.oldBias = oldBias;
    }

    public Double getOldWeight1() { return oldWeight1;}

    public void setOldWeight1(Double weight1) {
        this.oldWeight1 = oldWeight1;
    }

    public Double getOldWeight2() {
        return oldWeight2;
    }

    public void setOldWeight2(Double weight2) {this.oldWeight2 = oldWeight2;}

    public Neuron clone() {
        Neuron clone = new Neuron();
        clone.setBias(this.getBias());
        clone.setWeight1(this.getWeight1());
        clone.setWeight2(this.getWeight2());
        clone.setOldBias(this.getOldBias());
        clone.setOldWeight1(this.getOldWeight1());
        clone.setOldWeight2(this.getOldWeight2());
        return clone;
    }

    public Boolean equals(Neuron n) {
        if (this.bias == n.bias && this.weight1 == n.weight1 && this.weight2 == n.weight2) {
            return true;
        } else {
            return false;
        }
    }
}
