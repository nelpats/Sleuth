package fr.nelpats.model.detection.algorithm;

import java.util.Random;

public class Gpt extends Algorithm{

    private static final int MIN_DELAY_MS = 10;
    private static final int MAX_DELAY_MS = 170;
    @Override
    public int getDelay() {
        return MIN_DELAY_MS + new Random().nextInt(MAX_DELAY_MS - MIN_DELAY_MS + 1);
    }
}
