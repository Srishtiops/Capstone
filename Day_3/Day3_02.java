
public class Day3_02 {
    public static void main(String[] args) {
        int n = 40;

        boolean[] prime = new boolean[n + 1];  //default value of boolean is value is false
        sieve(n, prime);

    }
    static void sieve(int n, boolean[] prime) {
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) {
                System.out.println(i);
            }
        }
    }
}
