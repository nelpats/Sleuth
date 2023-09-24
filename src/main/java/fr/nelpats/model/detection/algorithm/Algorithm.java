package fr.nelpats.model.detection.algorithm;

public abstract class Algorithm {

    public abstract int getDelay();


    public double[] getDelaySample(int n) {
        double[] result = new double[n];

        for (int i = 0; i < n; i++) {
            result[i] = getDelay();
        }
        return result;
    }

    public Algorithm() {

    }
}
