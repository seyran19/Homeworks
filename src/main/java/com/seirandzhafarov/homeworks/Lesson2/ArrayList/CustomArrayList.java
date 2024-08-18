package com.seirandzhafarov.homeworks.Lesson2.ArrayList;

import com.seirandzhafarov.homeworks.Lesson2.QuickSort.QuickSort;


import java.util.Arrays;
import java.util.Collection;

public class CustomArrayList<T> {

    private QuickSort quickSort;
    private Object[] arr;
    private int size = 0;

    public CustomArrayList() {
        this.quickSort = new QuickSort();
        this.arr = new Object[10];
    }

    public boolean add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        // Увеличиваем размер массива, если он заполнен
        if (size == arr.length) {
            grow();
        }

        // Сдвигаем элементы вправо от указанного индекса
        System.arraycopy(arr, index, arr, index + 1, size - index);

        // Вставляем новый элемент
        arr[index] = element;

        // Увеличиваем размер
        size++;

        return true;
    }


    public boolean add(T element) {
        if (size == arr.length) {
            grow();
        }
        arr[size++] = element; // добавляем элемент в следующий свободный индекс и увеличиваем размер
        return true;
    }

    private void grow() {
        this.arr = (T[]) new Object[(int) Math.round((arr.length * 1.5) + 1)];
    }

    public boolean addAll(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
        }
        return true;
    }

    public boolean clear(){
        this.arr = (T[]) new Object[this.arr.length];
        this.size = 0;
        return true;
    }

    public T get(int index) {
        return (T) arr[index];
    }

    public boolean isEmpty(){
        if (arr.length == 0) return true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) return false;
        }
        return true;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        // Сдвигаем все элементы после удаленного на одну позицию влево
        System.arraycopy(this.arr, index + 1, this.arr, index, size - index - 1);
        this.arr[--size] = null; // уменьшаем размер и обнуляем последний элемент
    }


    public void remove(T element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].equals(element)) {
                remove(i);
            }
        }
    }

    public void quickSort(){

        // Преобразуем массив Object[] в массив Comparable[]
        Comparable[] comparableArr = Arrays.copyOf(this.arr, this.arr.length, Comparable[].class);

        // Выполняем сортировку
        quickSort.quickSort(comparableArr, 0, size - 1);

        // Копируем отсортированный массив обратно в arr
        this.arr = comparableArr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(arr[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}

