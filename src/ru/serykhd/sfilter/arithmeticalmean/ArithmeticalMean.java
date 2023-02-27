package ru.serykhd.sfilter.arithmeticalmean;


import ru.serykhd.sfilter.MathFilter;

/**
 * Среднее арифметическое
 */
public class ArithmeticalMean implements MathFilter {

    /**
     * Массив истории
     */
    private final double[] history;

    /**
     * Текущий индекс в массиве
     */
    private int currentElementIndex;

    /**
     * Сумма всех значений массива
     */
    private double avg;

    /**
     * Создает фильтр на основе среднего арифметического значения.
     * Данная версия эффективно работает на любом количестве элементов т.к. элементы в массиве не сдвигаются каждый вызов благодаря локальному индексу
     * @param length размер истории
     */
    public ArithmeticalMean(int length) {
        this.history = new double[length];
    }

    @Override
    public void add(double value) {
        // благодаря введенному индексу по текущему курсору в массиве
        // мы не сдвигаем каждый элемент в массиве что даёт максимальную производительность алгоритма
        // Повышаем текущий индекс в массиве преинкрементом, и если он равен размеру массива скидываем его в начало
        if (++currentElementIndex == history.length) {
            currentElementIndex = 0;
        }

        // Отнимаем самое старое значение массива из суммы значений
        avg -= history[currentElementIndex];

        // Прибавляем новое значение в сумму значений
        avg += value;

        // Кладем новое значение в массив
        history[currentElementIndex] = value;
    }

    @Override
    public double getAvg() {
        // Делим сумму всех значений на размер истории
        return avg / history.length;
    }
}