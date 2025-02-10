package pr;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// board
/*
[0,0,0,0,0],
[0,0,1,0,3],
[0,2,5,0,1],
[4,2,4,4,2],
[3,5,1,3,1]

바깥 배열(board)의 맨 뒤행부터 처리
 */
public class solution_크레인인형뽑기2 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int answer = new solution_크레인인형뽑기2().solution(board,moves);
    }
    public int solution(int[][] board, int[] moves) {
        int[] col_top_idx = new int[board[0].length]; // 일차원 배열에 각 컬럼별 최상위 인형의 index 관리

        // 컬럼(열) 이동하면서
        for (int col = 0; col < col_top_idx.length; col++) {
            // 맨 꼭대기부터 시작 0 이아닌 첫번째 index
            int top_idx = 0;
            while (top_idx < board.length - 1 && board[top_idx][col] == 0) {
                top_idx++;
                col_top_idx[col] = top_idx;
            }
        }

        Deque<Integer> bucket = new ArrayDeque<>(); // Stack 대신 ArrayDeque
        int answer = 0;

        for (int move : moves) {  // 1기반 index

           if(col_top_idx[move - 1] > board.length - 1)continue;

           // 꺼낼 인형이 있다.
           int doll = board[col_top_idx[move - 1]][move - 1];
           col_top_idx[move - 1]++; // 현재 최상 높이의 인형을 꺼내고 하나 밑으로 조정


               if (!bucket.isEmpty() && bucket.peek() == doll) { // 같은 인형
                   bucket.pop();  // 맨 꼭대기 인형 꺼냄.
                   answer +=2;
               }else {
                   bucket.push(doll);
               }
           }
        return answer;
    }
}
