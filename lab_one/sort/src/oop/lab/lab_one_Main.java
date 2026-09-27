package oop.lab;

/**
 * Класс для выполнения лабораторной работы №1.
 * Содержит статический массив целых чисел и методы
 * для его сортировки по возрастанию и убыванию.
 *
 * @author Попов С.А.
 * @version 1.0
 */
public class lab_one_Main {

    /**
     * Статический массив целых чисел для сортировки.
     * Изначально содержит 10 элементов.
     */
    private static int[] array = {
            5, 3, 8, 1, 9, 2, 7, 4, 6, 0
    };

    /**
     * Главный метод программы.
     *
     * Выводит исходный массив, выполняет его сортировку
     * по возрастанию и по убыванию, после чего выводит
     * полученные результаты.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {

        System.out.println("Мы начинаем программировать на Java!");

        System.out.print("Исходный массив: ");
        printArray(array);

        // Сортировка по возрастанию
        sortArray(array, true);

        System.out.print("Массив по возрастанию: ");
        printArray(array);

        // Сортировка по убыванию
        sortArray(array, false);

        System.out.print("Массив по убыванию: ");
        printArray(array);
    }

    /**
     * Сортирует массив целых чисел методом пузырьковой сортировки.
     *
     * <p>
     * Направление сортировки определяется параметром {@code ascending}.
     * Если {@code ascending} равен {@code true}, массив сортируется
     * по возрастанию. Если {@code false} — по убыванию.
     * </p>
     *
     * @param arr массив целых чисел для сортировки
     * @param ascending направление сортировки:
     *                  {@code true} — по возрастанию,
     *                  {@code false} — по убыванию
     */
    public static void sortArray(int[] arr, boolean ascending) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                /*
                 * При сортировке по возрастанию:
                 * меняем элементы, если левый больше правого.
                 *
                 * При сортировке по убыванию:
                 * меняем элементы, если левый меньше правого.
                 */
                boolean condition = ascending
                        ? (arr[j] > arr[j + 1])
                        : (arr[j] < arr[j + 1]);

                if (condition) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Выводит элементы массива в консоль через пробел.
     *
     * @param arr массив целых чисел для вывода
     */
    public static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}