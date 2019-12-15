import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] x = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            x[i] = arItem;
        }

        Arrays.sort(x);

        int[] l;
        int[] u;
        if (n%2==0) { //четное
            l = Arrays.copyOfRange(x, 0, n/2);
            u = Arrays.copyOfRange(x, n/2,n);
        } else {
            l = Arrays.copyOfRange(x, 0, n/2);
            u = Arrays.copyOfRange(x, n/2+1, n);
        }
        int q1 = (int) calcMedian(l);
        int q2 = (int) calcMedian(x);
        int q3 = (int) calcMedian(u);

        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);

    }

    private static double calcMedian(int[] param) {
        double median = 0;
        int n = param.length;
        if (n%2==0) { //четное
            median = ((double) (param[n/2] + param[(n/2)-1]))/2;
        } else {
            median = param[n/2];
        }

        return median;
    }

}
