package pr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_오픈채팅방2 {
    // 닉네임이 최종적으로 변경된 것을 선택
    // 닉네임은 유저아이디 별로 관리
    // 전체 진행 record 를 추적하면서 각 유저아이디별 최종 닉네임을 관리 ( Enter, Change 추적 )
    //   => 유저아이디별 닉네임을 관리 <= HashMap (key=유저아이디, value=닉네임)
    // 정답의 문자열 배열은 다시 전체 진행 record 를 추척 Enter, Leave 만 대상으로 문자열을 구성하는데, 닉네임은  HashMap 을 이용해서 처리


    // 교재 풀이
    // 리팩토링
    // 1. foreach -> for with index
    // 2. StringTokenizer, StringBuilder
    // 3. msg, HashMap 제거
    // 4. 무조건 split() -> 선택지 처리
    public String[] solution(String[] record) {
        // Enter, Leave 에 대한 문자열도 HashMap 에 관리
//        HashMap<String, String> msg = new HashMap<>();
//        msg.put("Enter", "님이 들어왔습니다.");
//        msg.put("Leave", "님이 나갔습니다.");

        // 유저아이디별 닉네임 관리 HashMap
        // Enter, Change 대상
        HashMap<String, String> uid = new HashMap<>();

        for(int i = 0; i < record.length; i++){
            char first = record[i].charAt(0);
            if (first == 'E' || first == 'C'){
                StringTokenizer st = new StringTokenizer(record[i]);
                st.nextToken();
                uid.put(st.nextToken(), st.nextToken());
            }
        }

//        for (String s : record) {
//            String[] cmd = s.split(" ");
//            if( cmd.length == 3 ) {
//                uid.put(cmd[1], cmd[2]); //  cmd[1] : 유저아이디 인데, 이 값이 중복되면 덮어쓴다. 최신화
//            }
//        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < record.length; i++) {
            char first = record[i].charAt(0); // 문자열 맨 앞자리 문자
            if (first == 'E' || first == 'L'){
                StringTokenizer st = new StringTokenizer(record[i]);
                st.nextToken();
                sb.append(uid.get(st.nextToken())).append( first == 'E' ? "님이 들어왔습니다.," : "님이 나갔습니다.,"); // , 추가
            }
        }

        sb.setLength(sb.length()-1); // 전체 문자열 마지막 , 제거
        return sb.toString().split(",");

        // 정답 구성
    }


}
/*
"Enter uid1234 Muzi",
"Enter uid4567 Prodo",
"Leave uid1234",
"Enter uid1234 Prodo",
"Change uid4567 Ryan"
*/
/*
테스트 1 〉 통과 (1.43ms, 74.2MB)
테스트 2 〉 통과 (1.47ms, 73.7MB)
테스트 3 〉 통과 (2.06ms, 81.4MB)
테스트 4 〉 통과 (1.45ms, 92.2MB)
테스트 5 〉 통과 (9.49ms, 77MB)
테스트 6 〉 통과 (7.52ms, 94.2MB)
테스트 7 〉 통과 (5.54ms, 93.9MB)
테스트 8 〉 통과 (6.44ms, 78.6MB)
테스트 9 〉 통과 (38.83ms, 79.6MB)
테스트 10 〉    통과 (14.25ms, 87.9MB)
테스트 11 〉    통과 (3.62ms, 81.2MB)
테스트 12 〉    통과 (13.53ms, 74.5MB)
테스트 13 〉    통과 (5.61ms, 74.7MB)
테스트 14 〉    통과 (5.84ms, 74.8MB)
테스트 15 〉    통과 (1.34ms, 82.7MB)
테스트 16 〉    통과 (1.29ms, 76.4MB)
테스트 17 〉    통과 (2.51ms, 75.5MB)
테스트 18 〉    통과 (2.66ms, 78MB)
테스트 19 〉    통과 (8.24ms, 88.2MB)
테스트 20 〉    통과 (8.90ms, 76.2MB)
테스트 21 〉    통과 (6.19ms, 82.9MB)
테스트 22 〉    통과 (10.75ms, 75.8MB)
테스트 23 〉    통과 (6.84ms, 75.3MB)
테스트 24 〉    통과 (7.81ms, 84.4MB)
테스트 25 〉    통과 (145.61ms, 163MB)
테스트 26 〉    통과 (170.95ms, 171MB)
테스트 27 〉    통과 (185.64ms, 167MB)
테스트 28 〉    통과 (167.08ms, 167MB)
테스트 29 〉    통과 (175.39ms, 189MB)
테스트 30 〉    통과 (141.27ms, 182MB)
테스트 31 〉    통과 (136.96ms, 168MB)
테스트 32 〉    통과 (139.17ms, 154MB)
*/