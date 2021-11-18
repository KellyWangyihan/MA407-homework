public class PrimeAtLeast {

    //Name: Wang Yihan;
    //ID: 202054602;
    //Email: Y.Wang437@lse.ac.uk;

    static boolean Prime(int n) {
        boolean isPrime = true;
        if (n <= 1) {
            isPrime = false;
            return isPrime;
        }
        else {
            for (int i = 2; i <= n / 2; i++) {
                if ((n % i) == 0) {
                    isPrime = false;
                    break;
                }
            }
            return isPrime;
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean isPrime = Prime(n);
        if (isPrime) {
            System.out.println(n);
        }
        else {
            int x = 0;
            while (!Prime(n + x)) {
                x++;
            }
            System.out.print(n + x);
        }

    }
}

