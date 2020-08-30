package cinos.backend.utils;

import java.util.concurrent.ThreadLocalRandom;

public class Random {

    public static int getRandomBetweenRange(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
