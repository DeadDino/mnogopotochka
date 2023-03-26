package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        // ожидание нажатия клавиши для остановки программы
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        producerThread.interrupt();
        consumerThread.interrupt();
        System.out.println("End");
    }
}