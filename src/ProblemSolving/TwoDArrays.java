package ProblemSolving;

import java.util.*;

public class TwoDArrays {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();
        int max = 0;
        for(int i = 1; i < 5; i++){
            for(int j = 1; j < 5; j++){
                int current = 0;
                current+=arr[i][j];
                current+=arr[i-1][j];
                current+=arr[i-1][j-1];
                current+=arr[i-1][j+1];
                current+=arr[i+1][j];
                current+=arr[i+1][j-1];
                current+=arr[i+1][j+1];
                if(current > max){
                    max = current;
                }
            }
        }
        System.out.println(max);
    }
}
