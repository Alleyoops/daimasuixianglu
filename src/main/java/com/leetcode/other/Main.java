package com.leetcode.other;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;
            // 长度 2
            for (int i = 0; i < n - 1; i++) {
                int mid = a[i + 1];
                int min = Math.min(a[i], a[i + 1]);
                ans = Math.max(ans, mid - min);
            }
            // 长度 3
            for (int i = 0; i < n - 2; i++) {
                int mid = a[i + 1];
                int min = Math.min(a[i], Math.min(a[i + 1], a[i + 2]));
                ans = Math.max(ans, mid - min);
            }

            pw.println(ans);
        }
        pw.flush();
    }
}