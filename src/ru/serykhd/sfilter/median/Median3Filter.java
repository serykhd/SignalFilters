package ru.serykhd.sfilter.median;


import ru.serykhd.sfilter.MathFilter;

/**
 * Медианный фильтр 3 порядка
 */
public class Median3Filter implements MathFilter {

    /**
     * Массив истории
     */
    private final double[] history = new double[3];

    /**
     * Текущий индекс в массиве
     */
    private int currentElementIndex;

    /**
     * Значение медианы
     */
    private double middle;

    @Override
    public void add(double value) {
        // Кладем новое значение в массив
        history[currentElementIndex] = value;

        // Повышаем текущий индекс в массиве преинкрементом, и если он равен размеру массива скидываем его в начало
        if (++currentElementIndex == history.length) {
            currentElementIndex = 0;
        }

        // достаем по элементу с массива
        double a = history[0];
        double b = history[1];
        double c = history[2];

        // согласно алгоритму сравниваем какое значение больше либо равно другому и присваиваем middle нужную величину

        // middle = (max(a,b) == max(b, c)) ? max(a, c) : max(b, min(a, c)); // c++
        if ((a <= b) && (a <= c)) {
            middle = (b <= c) ? b : c;
            return;
        }

        if ((b <= a) && (b <= c)) {
            middle = (a <= c) ? a : c;
            return;
        }

        middle = (a <= b) ? a : b;
    }

    @Override
    public double getAvg() {
        return middle;
    }
}