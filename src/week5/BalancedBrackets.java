package week5;

import edu.princeton.cs.algs4.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        Stack<Character> stackBracket = new Stack<Character>();

        for (Character c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stackBracket.push(c);
            } else if (!stackBracket.isEmpty()) {
                Character cPrev = stackBracket.pop();

                if (c == ')' && cPrev != '(') return "NO";
                else if (c == ']' && cPrev != '[') return "NO";
                else if (c == '}' && cPrev != '{') return "NO";

            } else return "NO";
        }

        if (stackBracket.isEmpty()) return "YES";
        else return "NO";

    }
}
