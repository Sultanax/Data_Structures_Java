public class GCD {
    public static void main (String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java GCD <integer m> <integer n>");
            System.exit(1);
        }
        try {
            int m = Integer.parseInt(args[0]);
            int n = Integer.parseInt(args[1]);
            if (m == 0 && n == 0) {
                System.out.println("gcd(0, 0) = undefined");
            }
            else {
                System.out.println("Iterative: gcd(" + m + ", " + n + ") = " + iterativeGcd(Math.abs(m), Math.abs(n)));
                System.out.println("Recursive: gcd(" + m + ", " + n + ") = " + recursiveGcd(Math.abs(m), Math.abs(n)));
                System.exit(0);
            }
        } catch (NumberFormatException e){
            if (e.getMessage().contains(args[0])) {
                System.err.println("Error: The first argument is not a valid integer.");
            }
            if (e.getMessage().contains(args[1])){
                System.err.println("Error: The second argument is not a valid integer.");
            }
            System.exit(1);
        }
    }

    public static int iterativeGcd(int m, int n) {
        if (n==0) {
            return m;
        }
        else if (m ==0) {
            return n;
        }
        while (m!=n) {
            if (m>n) {
                m -= n;
            }
            else {
                n -= m;
            }
        }
        return m;
    }

    public static int recursiveGcd(int m, int n) {
        if (n ==0) {
            return m;
        } else if (m ==0) {
            return n;
        } else if (m == n) {
            return m;
        } else if (m > n) {
            return recursiveGcd(m - n, n);
        } else {
            return recursiveGcd(m, n - m);
        }
    }
}