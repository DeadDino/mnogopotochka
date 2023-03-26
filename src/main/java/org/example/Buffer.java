package org.example;

public class Buffer {
    private int[] data;
    private int size;
    private int count;

    public Buffer(int size) {
        this.data = new int[size];
        this.size = size;
        this.count = 0;
    }

    public synchronized void put(int value) throws InterruptedException {
        while (count == size) {
            wait(); // ожидание освобождения места в буфере
        }
        data[count++] = value;
        notifyAll(); // оповещение о том, что в буфер добавлен элемент
    }

    public synchronized int get() throws InterruptedException {
        while (count == 0) {
            wait(); // ожидание появления элементов в буфере
        }
        int value = data[--count];
        notifyAll(); // оповещение о том, что из буфера удален элемент
        return value;
    }
}
