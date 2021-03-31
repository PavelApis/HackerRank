package ProblemSolving;

import java.util.*;


public class Binary {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();
        String s = Integer.toBinaryString(n);
        int max = 0;
        int current = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                current++;
            }
            if(s.charAt(i) == '0' || i+1==s.length()) {
                if(max < current) {
                    max = current;
                }
                current = 0;
            }
        }
        System.out.println(max);
    }
}
