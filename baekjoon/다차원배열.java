package baekjoon;


import java.io.IOException;

public class 다차원배열 {

    public static void main(String[] args) throws IOException {
        int arr[][];
        arr = new int[3][4];    //빈칸

        // 12개의 정수를 랜덤하게 발생시켜 배열에 순서대로 저장함.
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++)
                arr[i][j] = (int)(Math.random()*10);    //0~9까지의 랜덤 변수

        for (int i=0; i<arr.length; i++) {      // arr.length 빈칸
            for (int j=0; j<arr[i].length; j++)     // arr[i].length빈칸
                System.out.print(arr[i][j] + " ");  // 원소 출력 빈칸

            System.out.println();
        }

        // 3x4 배열의 합을 구하여 출력한다
        int i=0, sum=0;
         while(i<3) {
             // 3개의 각행에 대해 반복함
//             for (int a = 0; a < arr.length; a++) {
//                 for (int b = 0; b < arr[a].length; b++) {
//                     sum += arr[a][b];
//                 }
//             }
             for (int j=0; j<arr[i].length; j++){
                 sum+=arr[i][j];
             }
             i++;
         }
        System.out.println("합계=" + sum);

    }
}
