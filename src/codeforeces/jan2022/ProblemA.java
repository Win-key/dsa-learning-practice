package codeforeces.jan2022;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tests = scanner.nextInt();
        for (int i = 0; i < tests; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            if (k <= (n / 2 + 1)) {
                for(int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        if(j == l && j%2 == 0 & k > 0) {
                            System.out.print("R");
                            k--;
                        }
                        else
                            System.out.print(".");
                    }
                    System.out.println();
                }
            } else
                System.out.println(-1);
        }

        scanner.close();

    }
}
