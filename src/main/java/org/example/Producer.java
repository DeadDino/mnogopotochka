package org.example;

public class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            while (true) {
                int value = produce();
                buffer.put(value);
            }
        } catch (InterruptedException e) {
            System.out.println("Producer stopped");
        }
    }

    private int produce() throws InterruptedException {
        // генерация случайного числа
        return (int) (Math.random() * 100);
    }
}
