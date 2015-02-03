package com.shawn.algorithm.basic.structure;

import com.shawn.algorithm.helper.StdIn;
import com.shawn.algorithm.helper.StdOut;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Iterator;

public class BagTest extends TestCase {

    @Test
    public void testBagWithANumberOfElements(){
        Bag<Double> numbers = new Bag<>();
        while(!StdIn.isEmpty()){
            numbers.add(StdIn.readDouble());
        }
        int N =numbers.size();
        double sum = 0.0;

        for (Double e: numbers){
            sum += e;
        }

        double mean = sum / N;

        sum = 0.0;
        for (double e: numbers){
            sum += (e - mean) * (e - mean);
        }

        double std = Math.sqrt(sum/(N - 1));

        StdOut.printf("Mean: %.2f \n", mean);
        StdOut.printf("Std dev : %.2f \n", std);

        assertEquals(100, mean, 1);
        assertEquals(11,std, 1);
    }
}