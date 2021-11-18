// Yihan Wang
// ID: 202054602
// email: Y.Wang437@lse.ac.uk

public class SwitchSort {
    // Exercise 4.1

    static int[] switchSort(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < (x.length - 1 - i); j++) {
                if (x[j] > x[j + 1]) {
                    count++;
                    int tem = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = tem;
                }
            }
        }
        return x;
    }

    public static void printArray(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // Exercise 4.2
        if (args.length > 0) {
            int x[] = new int[args.length];
            for (int n = 0; n < args.length; n++) {
                x[n] = Integer.valueOf(args[n]);
            }
            System.out.print("before sorting: ");
            printArray(x);
            System.out.print("after sorting: ");
            printArray(switchSort(x));
        }

        // Exercise 4.4
        else if (args.length == 0) {

            // Example1 [Best]
            int[] x1 = new int[10000];
            for (int i = 0; i < x1.length; i++) {
                x1[i] = i;
            }
            int[] new_x1 = switchSort(x1);
            Type(x1);
            RunningTime(new_x1.length, x1);
            System.out.println(count + " switches needed.");

            // Example2 [Worst]
            int[] x2 = new int[10000];
            for (int j = 0; j < x2.length; j++) {
                x2[j] = -j;
            }
            int[] new_x2 = switchSort(x2);
            Type(x2);
            RunningTime(new_x2.length, x2);
            System.out.println(count + " switches needed.");

            // The above example works fine in my intelli J , and the answers were also the same as expected,
            // The result I got is as follow:
            //     Ordered numbers:
            //     Sorting 10000 numbers needed 13 ms.
            //     0 switches needed.
            //     Reversely ordered numbers:
            //     Sorting 10000 numbers needed 27 ms.
            //     49995000 switches needed.
            // But when the codes run in the auto grader, it automatically add 160 to the number of switches. And also because of that, the type of the array (ordered/reversely ordered) disappeared.
            // Could you please help me with this problem? Thank you.

            Test(10000);
            Test(20000);
            Test(40000);
        }


    }

    // Exercise 4.3
    // Terminates: The loop will stop when i=x.length-1, because the condition of the loop is i<x.length-1. The loop will not continue to run if it does not meet this condition, so the algorithm terminates.
    // Correctness:
    //        Initialisation: The loop invariant is true before the first iteration. i=0,and j=0 at the beginning of the loop.
    //        Maintenance: x[i] defines the number of iteration,
    //                     x[j] defines the current value, and x[j+1] is the value in the right hand side of x[j].
    //                     They compares with each other, and if x[j]<=x[j+1], the order of this two items will not change. However, if x[j]>x[j+1], they will switch the position.
    //                     The comparison starts at the first element in the array, and it will compare with the second element. Then as i++, the comparison happened between the second and the third. So every two elements were compared.
    //                     Because the larger number in one comparison group will be moved to the right, as the loop continues, the larger number will continue to compare with new element in its right hand side until it meets a larger number.
    //                     Therefore, the array is sorted by switching larger number to the right.
    //
    // Running time: The worst running time happened when the array is reversely ordered, and in that case, the running time of the algorithm is T(n)=n*(n-1)*1/2, the highest term is n^2,
    //               So that O(n^2).
    //
    //
    //
    // Examples:
    // Example1: 【best case】 An array [6,7,8,9], has n=4 items
    //        6 compares with 7, 6<7, so they switch the position. New array becomes [6,7,8,9],
    //        7 compares with 8, 7<8, so they switch the position. New array becomes [6,7,8,9],
    //        8 compares with 9, 8<9, so they switch the position. New array becomes [6,7,8,9],
    //
    //        Above all, they compares 3 times, so the best running time is n-1
    //        In the best case, T(n)=n-1, and big-O is O(n)
    //
    // Example2: 【worst case】 An array [5,4,3,2,1], has n=5 items
    //        5 compares with 4, 5>4, so they switch the position. New array becomes [4,5,3,2,1],
    //        5 compares with 3, 5>3, so they switch the position. New array becomes [4,3,5,2,1],
    //        5 compares with 2, 5>2, so they switch the position. New array becomes [4,3,2,5,1],
    //        5 compares with 1, 5>1, so they switch the position. New array becomes [4,3,2,1,5],
    //
    //        4 compares with 3, 4>3, so they switch the position. New array becomes [3,4,2,1,5],
    //        4 compares with 2, 4>2, so they switch the position. New array becomes [3,2,4,1,5],
    //        4 compares with 1, 4>1, so they switch the position. New array becomes [3,2,1,4,5],
    //
    //        3 compares with 2, 3>2, so they switch the position. New array becomes [2,3,1,4,5],
    //        3 compares with 1, 3>1, so they switch the position. New array becomes [2,1,3,4,5],
    //
    //        2 compares with 1, 2>1, so they switch the position. New array becomes [1,2,3,4,5],

    //        Above all, the worst running time is 4+3+2+1 = (4+1)*4*1/2 = n*(n-1)*1/2 = 10
    //        So in the worst case, the running time is T(n) = n*(n-1)*1/2, and big-O is O(n^2)
    //


    // Exercise 4.4
    static int count = 0;

    static void randomFill(int[] x) {
        for (int i = 0; i < x.length; i++) {
            x[i] = (int) ((double) x.length * Math.random());
        }
    }

    static void Test(int n) {
        System.out.println("Random numbers: ");
        int[] r = new int[n];
        randomFill(r);
        RunningTime(n, r);
        System.out.println(count + " switches needed");
    }

    static void Type(int[] x) {
        int n = x.length;
        switchSort(x);
        if (count == 0) {
            System.out.println("Ordered numbers: ");
        }
        else if (count == (n * (n - 1)) / 2) {
            System.out.println("Reversely ordered numbers: ");
        }
    }


    static void RunningTime(int n, int[] x) {
        long time = System.currentTimeMillis();
        switchSort(x);
        time = System.currentTimeMillis() - time;
        System.out.println("Sorting " + n + " numbers needed " + time + " ms.");
    }

    // Main method above.

}

