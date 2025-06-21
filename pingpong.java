class PingPong {
    private boolean isPingTurn = true; // true = Ping's turn, false = Pong's turn

    // Synchronized method for printing Ping
    public synchronized void printPing() throws InterruptedException {
        while (!isPingTurn) {
            wait(); // wait until it's Ping's turn
        }
        System.out.println("Ping");
        Thread.sleep(500); // 500ms delay
        isPingTurn = false; // next turn is Pong
        notify(); // notify waiting thread
    }

    // Synchronized method for printing Pong
    public synchronized void printPong() throws InterruptedException {
        while (isPingTurn) {
            wait(); // wait until it's Pong's turn
        }
        System.out.println("Pong");
        Thread.sleep(500); // 500ms delay
        isPingTurn = true; // next turn is Ping
        notify(); // notify waiting thread
    }
}

public class pingpong {
    public static void main(String[] args) {
        PingPong pp = new PingPong();

        // Thread for Ping
        Thread pingThread = new Thread(() -> {
            try {
                while (true) {
                    pp.printPing();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Thread for Pong
        Thread pongThread = new Thread(() -> {
            try {
                while (true) {
                    pp.printPong();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Start both threads
        pingThread.start();
        pongThread.start();
    }
}
