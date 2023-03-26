package org.example;

public class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            while (true) {
                int value = buffer.get();
                consume(value);
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer stopped");
        }
    }

    private void consume(int value) {
        // обработка данных
        System.out.println("Consumed: " + value);
    }
}
