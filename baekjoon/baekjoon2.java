package baekjoon;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;



public class baekjoon2 {
    static int[] intArr;
    static int[] tgtArr;
    static boolean[] boolArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        perm(0);

        intArr = new int[n];
        tgtArr = new int[m];
        boolArr = new boolean[n];

        for (int i = 0; i < n; i++) {
            intArr[i] = i+1;
        }


    }
    static void perm (int tgtidx) {

        if(tgtidx == tgtArr.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tgtArr.length; i++) {
                if (i > 0) sb.append(" ");
                sb.append(tgtArr[i]);
            }
            System.out.println(sb);
            return;
        }

        for(int i = 0 ; i < intArr.length ; i++) {
            if(boolArr[i]) continue;

            tgtArr[tgtidx] = intArr[i];
            boolArr[i] = true;
            perm (tgtidx + 1);
            boolArr[i] = false;
        }
    }
}