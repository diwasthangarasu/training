interface LICAgent {
    void displayDetails(double amount);

    default void welcome() {
        System.out.println("Welcome, I'm an insurance agent");
    }
}

class LIC implements LICAgent {
    String agentName;

    LIC(String name) {
        this.agentName = name;
    }

    double calcPremium(double amount) {
        return amount * 0.05;
    }

    double calcReturns(double amount) {
        return amount * 0.02;
    }

    public void displayDetails(double amount) {
        welcome();
        System.out.println("Agent: " + agentName);
        System.out.println("Premium on " + amount + ": " + calcPremium(amount));
        System.out.println("Return on " + amount + ": " + calcReturns(amount));
    }
}

public class LICInherit {
    public static void main(String[] args) {
        LIC lic = new LIC("Diwas");
        double amount = 100000;
        lic.displayDetails(amount);
    }
}
