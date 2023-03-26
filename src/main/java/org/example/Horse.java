package org.example;

import java.util.Scanner;

public class Horse {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        var m = sc.nextInt();
        System.out.println(countSteps(n, m));
    }

    private static long countSteps(int n, int m) {
        long[][] field = new long[n + 1][m + 1];
        field[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                field[i][j] = field[i - 1][j - 2] + field[i - 2][j - 1];
            }
        }
        return field[n][m];
    }
}
