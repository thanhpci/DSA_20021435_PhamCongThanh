package week8;

import java.util.Scanner;

public class CountWord {
    public static String count(String s, String word) {
        int count = 0;
        int prevSpace = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                String wordCompare = s.substring(prevSpace, i);
                if (word.equals(wordCompare)) count++;
                s = s.substring(0, prevSpace) + s.substring(i + 1);
                prevSpace = i;
            }

            if (i == s.length() - 1) {
                String wordCompare = s.substring(prevSpace);
                if (word.equals(wordCompare)) count++;
                s = s.substring(0, prevSpace);
                prevSpace = i;
            }
        }
        System.out.println(word + " " + count);
        return s;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();

        String s = "1 2";
        while(!s.isEmpty()) {

            String word = "";

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    word = s.substring(0, i);
                    s = count(s, word);
                    break;
                }

                if (i == s.length() - 1) {
                    word = s;
                    s = count(s, word);
                    break;
                }
            }
        }

    }


}
