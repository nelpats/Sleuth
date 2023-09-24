package fr.nelpats.model.detection.algorithm;

import java.util.Random;

public class Kenyhnrv extends Algorithm{

    private Random random = new Random();

    @Override
    public int getDelay() {
        int cps = 10;
        return (int)((random.nextFloat() % (float)(2000 / cps)) * 100);

    }
}
