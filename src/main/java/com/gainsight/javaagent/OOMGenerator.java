package com.gainsight.javaagent;

import com.chimpler.example.agentmetric.Measured;
import com.sun.org.apache.xml.internal.utils.ThreadControllerWrapper;

import java.util.Random;

/**
 * Created by Sridhar(snagaraj@gainsight.com) on 23/06/16.
 */
public class OOMGenerator {

    private int outerIterator = 1;
    private int iteratorValue = 20;

    private Random random = new Random();


    @Measured
    public void generateOOM() throws Exception {

        System.out.println("\n=================> OOM started..\n");

        System.out.println("Iteration " + outerIterator + " Free Mem: " + Runtime.getRuntime().freeMemory());
        int loop1 = 2;
        int[] memoryFillIntVar = new int[iteratorValue];
        // feel memoryFillIntVar array in loop..
        do {
            memoryFillIntVar[loop1] = 0;
            loop1--;
        } while (loop1 > 0);
        iteratorValue = iteratorValue * 5;
        System.out.println("\nRequired Memory for next loop: " + iteratorValue);
        Thread.sleep(1000);
        outerIterator++;

    }

    @Measured
    public void measuredFunction() {

        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
