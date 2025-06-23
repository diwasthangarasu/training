import java.util.*;

public class LetterCombinations {
    static final String[] KEYPAD = {
        "",     
        "",     
        "abc",  
        "def",  
        "ghi",  
        "jkl",  
        "mno",  
        "pqrs", 
        "tuv",  
        "wxyz"  
    };
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        backtrack(result, digits, 0, new StringBuilder());
        return result;
    }

    private static void backtrack(List<String> result, String digits, int index, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = KEYPAD[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(result, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1); 
        }
    }

    public static void main(String[] args) {
        String input = "234"; 
        List<String> combinations = letterCombinations(input);

        System.out.println("Combinations for " + input + ":");
        for (String combo : combinations) {
            System.out.println(combo);
        }
    }
}
