package week5;

import java.util.List;

public class EqualStacks {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (var num : h1) sum1 += num;

        for (var num : h2) sum2 += num;

        for (var num : h3) sum3 += num;

        int index1 = 0, index2 = 0, index3 = 0, min;

        while (!EqualStacks.areEqual(sum1, sum2, sum3)) {
            min = EqualStacks.getMinHeight(sum1, sum2, sum3);
            while (sum1 > min && index1 < h1.size()) {
                sum1 -= h1.get(index1);
                index1++;
            }
            while (sum2 > min && index2 < h2.size()) {
                sum2 -= h2.get(index2);
                index2++;
            }
            while (sum3 > min && index3 < h3.size()) {
                sum3 -= h3.get(index3);
                index3++;
            }
            if (index1 == h1.size() || index2 == h3.size() || index3 == h3.size()) {
                sum1 = 0;
                break;
            }
        }
        min = sum1;
        return min;
    }

    public static boolean areEqual(int h1, int h2, int h3) {
        if (h1 == h2 && h1 == h3) {
            return true;
        }
        return false;
    }

    public static int getMinHeight(int h1, int h2, int h3) {
        if (Math.min(h1, h2) < Math.min(h2, h3)) {
            return Math.min(h1, h2);
        }
        return Math.min(h2, h3);
    }

}