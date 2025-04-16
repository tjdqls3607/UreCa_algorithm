package baekjoon;

import java.util.*;

public class bj_나무자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] H = new int[n];
        int[] G = new int[n];

        for (int i = 0; i < n; i++) H[i] = sc.nextInt();
        for (int i = 0; i < n; i++) G[i] = sc.nextInt();

        Tree[] trees = new Tree[n];
        for (int i = 0; i < n; i++) {
            trees[i] = new Tree(H[i], G[i]);
        }

        Arrays.sort(trees);  // G 기준 오름차순

        long total = 0;
        for (int day = 0; day < n; day++) {
            total += trees[day].height + (long)trees[day].grow * day;
        }

        System.out.println(total);
    }

    static class Tree implements Comparable<Tree> {
        int height, grow;

        Tree(int h, int g) {
            this.height = h;
            this.grow = g;
        }

        public int compareTo(Tree o) {
            return this.grow - o.grow; // G 기준 오름차순
        }
    }
}
