package week11;

import java.util.Scanner;
import java.util.TreeSet;

public class FindTheRunningMedian {
    public class Element implements Comparable {
        public int value;
        public int rankInArray;
        
        public Element(int value, int rankInArray) {
            this.value = value;
            this.rankInArray = rankInArray;
        }

        @Override
        public int compareTo(Object o) {
            Element element = (Element) o;
            if (this.value < element.value || (this.value == element.value && this.rankInArray < element.rankInArray)) return -1;
            if (this.value > element.value || (this.value == element.value && this.rankInArray > element.rankInArray)) return 1;
            return 0;
        }
        public String toString() {
            return value + " ";
        }
    }
    public void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        TreeSet<Element> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            int r = scanner.nextInt();
            Element e = new Element(v, r);
            treeSet.add(e);
            Element curE = treeSet.first();
            for (int j = 0; j < treeSet.size() / 2 - 1; j++) {
                curE = treeSet.higher(curE);
                System.out.println(curE);
            }
        }
    }

}
