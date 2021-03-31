package ProblemSolving;

/* Thaum plans to celebrate his friend Deeksha's birthday.
        * In total, there are two types of gifts that Deeksha wants to receive from Thaum: black and white.
        * For Deeksha to be happy, Thaum must buy b black and w white gifts.
        *
        * The cost of each black gift is bc units.
        * The cost of each white gift wc units.
        * The cost of exchanging each white gift for black or black for white is z units.

        * Help Thaum determine the minimum amount of money he needs to spend on gifts for Deeksha.
        *
        * Input data format:
        * The first line contains an integer t the number of tests.
        * It is followed by pairs of lines. The first line of each test case contains the b and w values. The second line contains bc, wc and z.
        *
        * Output data format:
        * t lines with answers for each test.
        *
        * Restrictions:
        * 1 <t <10
        * 0 <= b, w, bc, wc, z <= 10 ^ 9
        *
        * Example of input data:
        *  one
        * 10 10
        * 1 1 1
        *
        * Sample output:
        *  20
        *
        * Explanation:
        * It is unprofitable to exchange black gifts for white or white gifts for black,
        * so you have to buy all gifts at 1 unit. */

import java.io.*;
import java.util.stream.*;


class Result {

    /*
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER b    - number of the black gifts
     *  2. INTEGER w    - number of the white gifts
     *  3. INTEGER bc   - cost of the black gift
     *  4. INTEGER wc   - cost of the white gift
     *  5. INTEGER z    - cost of the trade
     */

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // finding the minimum cost of black and white gift
        while(bc+z<wc || wc+z < bc){
            if(bc+z<wc){
                wc = bc+z;
            }
            if(wc+z<bc){
                bc=wc+z;
            }
        }
        //returning the minimum money that needed to buy b of black gifts and w of white gifts
        return (long)b*bc+(long)w*wc;
    }

}

public class TaumAndBday {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int b = Integer.parseInt(firstMultipleInput[0]);

                int w = Integer.parseInt(firstMultipleInput[1]);

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int bc = Integer.parseInt(secondMultipleInput[0]);

                int wc = Integer.parseInt(secondMultipleInput[1]);

                int z = Integer.parseInt(secondMultipleInput[2]);

                long result = Result.taumBday(b, w, bc, wc, z);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
