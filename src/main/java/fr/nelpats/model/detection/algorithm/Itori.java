package fr.nelpats.model.detection.algorithm;

import java.util.Random;

public class Itori extends Algorithm {

    private final Random random = new Random(); // Create a single Random instance

    @Override
    public int getDelay() {
        double cps = 0.0D;
        double outliers = 0.0D;

        double delay = 1000.0 / (cps * random.nextDouble(0.75, 1.15));
        double dropChance = random.nextDouble(0.0, 100.0);
        double outChance = random.nextDouble(0.0, 100.0);

        if (outChance >= 80.0 && outChance < 90.0)
            delay -= outliers;
        if (outChance >= 90.0 && outChance < 95.0)
            delay -= outliers * 2.5;

        if (dropChance >= 93.0 && dropChance < 95.0)
            delay *= 1.10;
        if (dropChance >= 95.0 && dropChance < 98.0)
            delay *= 1.25;
        if (dropChance >= 98.0 && dropChance < 99.5)
            delay *= 1.5;
        if (dropChance >= 99.5)
            delay *= 2.5;

        return (int) delay;
    }
}
