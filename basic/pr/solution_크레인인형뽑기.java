package basic.pr;


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
public class solution_크레인인형뽑기 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>[] lanes = new Stack[board.length];
        for (int i = 0; i < lanes.length; i++) {
            lanes[i] = new Stack<>();
        }

        // 그리드 형태의 각 열별 stack 에 입력을 담는다.
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    lanes[j].push(board[i][j]);
                }
            }
        }
        // 스택의 내용 확인
//        for (int i=0; i<lanes.length; i++) {
//            System.out.println(Arrays.toString(lanes[i].toArray()));
//        }
        Stack<Integer> bucket = new Stack<>();

        for (int move : moves) {  // 1기반 index
           if(! lanes[move - 1].isEmpty()){
               int doll = lanes[move - 1].pop();
               if (!bucket.isEmpty() && bucket.peek() == doll) { // 같은 인형
                   bucket.pop();  // 맨 꼭대기 인형 꺼냄.
                   answer +=2;
               }else {
                   bucket.push(doll);
               }
           }
        }
        return answer;
    }
}
