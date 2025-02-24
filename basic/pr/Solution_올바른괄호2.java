package basic.pr;

// 스택 대신 배열을 그대로 이동
// 여는 괄호 중 맨 마지막 문자를 가리키는 index : oi
// 문자열 (배열) 맨 앞부터 순차적으로 따져가는 index : i
public class Solution_올바른괄호2 {

    public static void main(String[] args) {
        String s = "()()";
        System.out.println( new Solution_올바른괄호2().solution(s) );
    }
    boolean solution(String s) {

        char[] input = s.toCharArray();
        int len = input.length;
        int xCnt = 0; //  () 가 한 쌍으로 일치하면 'X' 로 표시, 그 건수
        for (int i = 0, oi = 0; i < len; i++) {

            if( input[i] == ')') { // 닫는 괄호
                if( input[oi] != '(' ) return false;

                //  두 괄호가 일치
                input[i] = 'X';
                input[oi] = 'X';
                xCnt += 2; // 일치해서 처리된 항목 수 2 증가

                while( oi > 0 && input[oi] == 'X' ) oi--;  // 현재 oi  자리가 'X' 가 되면서 이전 자리 중 여는 괄호가 있는 마지막 위치

            }else { // 여는 괄호
                oi = i;
            }
        }

        return xCnt == len;
    }
}
/*
테스트 1 〉 통과 (0.03ms, 72.4MB)
테스트 2 〉 통과 (0.03ms, 87.3MB)
테스트 3 〉 통과 (0.02ms, 81.1MB)
테스트 4 〉 통과 (0.03ms, 76.1MB)
테스트 5 〉 통과 (0.02ms, 83.7MB)
테스트 6 〉 통과 (0.02ms, 79.6MB)
테스트 7 〉 통과 (0.03ms, 81.8MB)
테스트 8 〉 통과 (0.03ms, 71.7MB)
테스트 9 〉 통과 (0.02ms, 86.7MB)
테스트 10 〉    통과 (0.03ms, 81.3MB)
테스트 11 〉    통과 (0.02ms, 82.8MB)
테스트 12 〉    통과 (0.04ms, 82.6MB)
테스트 13 〉    통과 (0.04ms, 84.8MB)
테스트 14 〉    통과 (0.03ms, 88.6MB)
테스트 15 〉    통과 (0.02ms, 78.3MB)
테스트 16 〉    통과 (0.08ms, 86.1MB)
테스트 17 〉    통과 (0.05ms, 85MB)
테스트 18 〉    통과 (0.04ms, 86.6MB)
*/