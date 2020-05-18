package lesson4;

public class MainClass {
    private final Object monitor = new Object();
    private volatile char currentLetter = 'A';
    private final int PRINT_SIZE = 5;

    public static void main(String[] args) {
        MainClass w = new MainClass();
        new Thread(()->w.printA()).start();
        new Thread(()->w.printB()).start();
        new Thread(()->w.printC()).start();
    }

    public void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < PRINT_SIZE; i++) {
                    while (currentLetter != 'A') {
                        monitor.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < PRINT_SIZE; i++) {
                    while (currentLetter != 'B') {
                        monitor.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < PRINT_SIZE; i++) {
                    while (currentLetter != 'C') {
                        monitor.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
