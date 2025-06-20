import java.util.ArrayList;
import java.util.Scanner;

public class RemovePrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++)
            list.add(sc.nextInt());

        list.removeIf(RemovePrimes::isPrime);
        System.out.println("List after removing primes: " + list);
        sc.close();
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++)
            if (num % i == 0) return false;
        return true;
    }
}