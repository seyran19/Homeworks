package com.seirandzhafarov.homeworks.Lesson2.QuickSort;

public class QuickSort {

    public void quickSort(Comparable[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(Comparable[] array, int low, int high) {
        Comparable pivot = array[high];
        int i = (low - 1); // индекс наименьшего элемента

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                // поменяем местами элементы array[i] и array[j]
                Comparable temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // поменяем местами элементы array[i+1] и array[high] (или pivot)
        Comparable temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
