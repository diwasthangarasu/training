import java.util.HashMap;
import java.util.Scanner;

public class CharFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Use a HashMap to count character frequencies
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            if (ch != ' ') { // ignore spaces
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }
        }

        System.out.println("Character frequencies:");
        for (char ch : freqMap.keySet()) {
            if (freqMap.get(ch) > 1) {
                System.out.println(ch + " → " + freqMap.get(ch));
            }
        }

        sc.close();
    }
}