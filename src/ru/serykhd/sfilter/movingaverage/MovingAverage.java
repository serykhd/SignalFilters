package ru.serykhd.sfilter.movingaverage;


import ru.serykhd.sfilter.MathFilter;

/**
 * Скользящая средняя
 */
public class MovingAverage implements MathFilter {

    private final double coeficient;

    private double avg;

    /**
     * Создает фильтр на основе скользящей средней
     * @param coeficient коэффициент степень сглаживания (0.00 - 1.00). Чем меньше, тем плавнее
     */
    public MovingAverage(double coeficient) {
        this.coeficient = coeficient;
    }

    @Override
    public void add(double value) {
        // от текущего значения отнимаем среднее, умножаем на кофф, результат прибавляем к среднему
        avg += (value - avg) * coeficient;
    }

    @Override
    public double getAvg() {
        return avg;
    }
}
