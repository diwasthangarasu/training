class WaterTank {
    private int capacity = 100;
    private int currentLevel = 0;

    synchronized void fill() {
        while (currentLevel < 80) {
            currentLevel += 10;
            System.out.println("Filling... Current Level: " + currentLevel + " liters");
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
        System.out.println("Reached ≥ 80%. Opening outlet...");
        notify();
    }

    synchronized void drain() {
        try { wait(); } catch (InterruptedException e) {}
        while (currentLevel > 0) {
            currentLevel -= 10;
            System.out.println("Draining... Current Level: " + currentLevel + " liters");
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
        System.out.println("Tank empty. Stopping outlet.");
    }
}

public class WaterTank2 {
    public static void main(String[] args) {
        WaterTank tank = new WaterTank();

        Thread inlet = new Thread(() -> tank.fill());
        Thread outlet = new Thread(() -> tank.drain());

        inlet.start();
        outlet.start();
    }
}
