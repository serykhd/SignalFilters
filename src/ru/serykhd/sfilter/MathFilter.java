package ru.serykhd.sfilter;

/**
 * Интерфейс с методами, которые должен иметь каждый фильтр унаследованный от этого интерфейса
 */
public interface MathFilter {

    /**
     * Добавляет новое значение
     */
    void add(double value);

    /**
     * Получаем результат
     */
    double getAvg();

    /**
     * Метод который необязательно реализовывать в унаследованных классах
     * Добавляет новое значение и отдает результат
     */
    default double addAngGet(double value) {
        add(value);
        return getAvg();
    }
}
