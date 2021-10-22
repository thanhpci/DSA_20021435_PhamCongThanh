package week5;

public class SelectionSort {
    public static void sort(Comparable[] a) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    private static void exch(Comparable[] a, int i, int min) {
        int tmp = (int) a[i];
        a[i] = a[min];
        a[min] = tmp;
    }

    private static boolean less(Comparable comparable1, Comparable comparable2) {
        if(comparable1.compareTo(comparable2) == -1) return true;
        else return false;
    }


    public static void main(String[] args) {
        Comparable[] arr = {1, 5,11, 99, 4, 7, 8,1,2,4, 90, 4,26};
        sort(arr);
        for(Comparable a : arr) {
            System.out.println(a);
        }
    }
}


