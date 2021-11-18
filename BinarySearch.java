// Yihan Wang
// ID: 202054602
// email: Y.Wang437@lse.ac.uk

// Exercise 3.1
// Assume we need "m" steps to complete the binary search
// After the first step, we have (n-1)/2 items remained to be compared;
// After the second step, we have (n-1)/4 items remained to be compared;
// After the third step, we have (n-1)/8 items remained to be compared;
// ...
// After the m.th step, we have (n-1)/(2^m) items remained to be compared;
// In the worst case, we keep comparing until there is only one item remained;
// so 2^m <= n-1;
// so that the maximum m is log_2(n-1) steps;
// we compare 2 times in each step,
// which means the maximum comparisons are 2*log_2(n-1);


import java.util.Arrays;

public class BinarySearch {

    // exercise 3.2
    public static int binsearch(int key, int x[], int i, int j) {
        int k = (j + i) / 2;
        if (j >= i) {
            if (x[k] == key) {
                return repeat(x, k);
            }
            if (x[k] > key) {
                return binsearch(key, x, i, k - 1);
            }
            if (x[k] < key) {
                return binsearch(key, x, k + 1, j);
            }
        }
        else {
        }
        return j + 1;
    }

    public static int repeat(int x[], int k) {
        if (x[k - 1] == x[k] && k > 0) {
            if (k - 1 == 0) {
                return k - 1;
            }
            else {
                return repeat(x, k - 1);
            }
        }
        else {
        }
        return k;
    }

    // exercise 3.3
    public static boolean found(int key, int x[], int i, int j) {
        if (i > j)
            return false;
        else {
            int k = (j + i) / 2;
            if (key == x[k])
                return true;
            else if (key < x[k])
                return found(key, x, i, k - 1);
            else if (key > x[k])
                return found(key, x, k + 1, j);
        }
        return false;
    }

    // exercise 3.4
    public static int counter(int n, boolean found, int k, int j) {
        if (found) {
            int count = (int) Math.ceil((Math.log(n) / Math.log(2)));
            return count;
        }
        else if (!found) {
            if (k >= j) {
                int count = (int) Math.ceil((Math.log(n) / Math.log(2)) + 1);
                return count;
            }
            else if (k < j) {
                int count = (int) Math.ceil((Math.log(n) / Math.log(2)));
                return count;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] x1 = { 7, 7, 10, 23, 42, 42, 42, 51, 60 };
        int key1 = Integer.parseInt(args[0]);
        int n1 = x1.length;
        int k1 = binsearch(key1, x1, 0, n1 - 1);
        boolean found1 = found(key1, x1, 0, n1 - 1);
        int count1 = counter(n1, found1, k1, n1 - 1);
        System.out.print("Testing a small array:" + Arrays.toString(x1));
        if (found1) {
            System.out.println(" Key " + key1 + " found at index " + k1 + ", after " + count1
                                       + " binary search iterations");
        }
        else {
            System.out.println(
                    " Key " + key1 + " not found, " + "should be at index " + k1 + ", after "
                            + count1
                            + " binary search iterations");
        }


        int[] x2 = new int[100000000];
        for (int i = 0; i < x2.length; i++) {
            x2[i] = 2 * i + 1;
        }
        int key2 = Integer.parseInt(args[1]);
        int n2 = x2.length;
        int k2 = binsearch(key2, x2, 0, n2 - 1);
        boolean found2 = found(key2, x2, 0, n2 - 1);
        int count2 = counter(n2, found2, k2, n2 - 1);
        System.out.print("Testing a large array with 10^8 entries: 1 3 5 7 ... 199999999");
        if (found2) {
            System.out.println(" Key " + key2 + " found at index " + k2 + ", after " + count2
                                       + " binary search iterations");
        }
        else {
            System.out.println(
                    " Key " + key2 + " not found, " + "should be at index " + k2 + ", after "
                            + count2
                            + " binary search iterations");
        }

        int[] x3 = new int[100000000];
        for (int i = 0; i < x3.length; i++) {
            x3[i] = 9;
        }
        int key3 = Integer.parseInt(args[2]);
        int n3 = x3.length;
        int k3 = binsearch(key3, x3, 0, n3 - 1);
        boolean found3 = found(key3, x3, 0, n3 - 1);
        int count3 = counter(n3, found3, k3, n3 - 1);
        System.out.print("Testing a large array with 10^8 identical entries: 9 9 9 ... 9");
        if (found3) {
            System.out.println(" Key " + key3 + " found at index " + k3 + ", after " + count3
                                       + " binary search iterations");
        }
        else {
            System.out.println(
                    " Key " + key3 + " not found, " + "should be at index " + k3 + ", after "
                            + count3
                            + " binary search iterations");
        }
    }
}
