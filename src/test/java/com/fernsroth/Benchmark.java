package com.fernsroth;

import org.junit.Test;

import java.util.Random;

public class Benchmark {
    private static final int PRIMING_ITERATIONS = 1;
    private static final int ITERATIONS = 1;
    private static final int NUMBER_OF_ITEMS = 1000000000;
    private static final Sort[] SORT_ALGORITHMS = new Sort[]{
            new QuickSort(),
            new MergeSort()
    };

    @Test
    public void benchmark() {
        long[] results = new long[SORT_ALGORITHMS.length];
        for (int i = 0; i < PRIMING_ITERATIONS; i++) {
            run(i, results);
        }
        results = new long[SORT_ALGORITHMS.length];
        for (int i = 0; i < ITERATIONS; i++) {
            run(i, results);
        }

        for (int i = 0; i < results.length; i++) {
            System.out.println(String.format(
                    "%s: %d",
                    SORT_ALGORITHMS[i].getClass().getSimpleName(),
                    results[i]
            ));
        }
    }

    private void run(int randomSeed, long[] results) {
        for (int i = 0; i < SORT_ALGORITHMS.length; i++) {
            long[] array = createArray(randomSeed);
            long startTime = System.currentTimeMillis();
            run(SORT_ALGORITHMS[i], array);
            long endTime = System.currentTimeMillis();
            results[i] += endTime - startTime;
        }
    }

    private long[] createArray(int randomSeed) {
        Random random = new Random(randomSeed);
        long[] array = new long[NUMBER_OF_ITEMS];
        for (int j = 0; j < array.length; j++) {
            array[j] = random.nextLong();
        }
        return array;
    }

    private void run(Sort sort, long[] array) {
        sort.sort(array);
    }
}
