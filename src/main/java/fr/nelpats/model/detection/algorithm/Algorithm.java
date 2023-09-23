package fr.nelpats.model.detection.algorithm;

public abstract class Algorithm {

    public abstract int getDelay();


    public int[] getDelaySample(int n) {
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = getDelay();
        }
        return result;
    }

    public Algorithm() {

    }
}
