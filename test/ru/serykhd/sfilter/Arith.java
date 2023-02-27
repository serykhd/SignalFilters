package ru.serykhd.sfilter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.serykhd.sfilter.arithmeticalmean.ArithmeticalMean;
import ru.serykhd.sfilter.median.Median3Filter;
import ru.serykhd.sfilter.movingaverage.MovingAverage;

public class Arith {

    @Test
    public void mean() {
        MathFilter filter = new ArithmeticalMean(3);

        filter.add(5);
        filter.add(5000);
        filter.add(200);

        Assertions.assertEquals(filter.getAvg(), 1735, 0.1);
    }

    @Test
    public void median3() {
        MathFilter filter = new Median3Filter();

        filter.add(5);
        filter.add(5000);
        filter.add(200);

        Assertions.assertEquals(filter.getAvg(), 200, 0.1);
    }

    @Test
    public void movingAvg() {
        MathFilter filter = new MovingAverage(0.05);

        filter.add(5);
        filter.add(5000);
        filter.add(200);

        Assertions.assertEquals(filter.getAvg(), 247.725, 0.1);
    }
}
