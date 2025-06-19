class LICAgent {
  String agentName;

  LICAgent(String name) {
    agentName = name;
  }
}

class LIC extends LICAgent {
  LIC(String name) {
    super(name);
  }

  double calcPremium(double amount) {
    return amount * 0.05;
  }

  double calcReturns(double amount) {
    return amount * 0.02;
  }

  void displayDetails(double amount) {
    System.out.println("Agent: " + agentName);
    System.out.println("Premium on " + amount + ": " + calcPremium(amount));
    System.out.println("Return on " + amount + ": " + calcReturns(amount));
  }
}

public class LICi {
  public static void main(String[] args) {
    LIC lic = new LIC("Diwas");
    double amount = 100000; 
    lic.displayDetails(amount);
  }
}
