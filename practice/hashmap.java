package practice;

import java.util.HashMap;

public class hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("apple", 1);    // apple 이라는 키와 값 1 삽입
        map.put("orange", 2);
        map.put("banana", 3);

        // System.out.println(map); // map 출력

        // 해시맵 키를 이용하여 데이터 검색
//        String key = "apple";
//        if (map.containsKey(key)) {
//            int value = map.get(key);   // get 을 사용하여 value 저장
//            System.out.println(key + ": " + value);
//        }else {
//            System.out.println(key + ": not found"); //String 값이 해시맵에 존재하지 않는경우 notfound 출력
//        }

//        map.put("banana", 4);   // 해시맵의 banana 라는 key에 value를 4로 변경
//        System.out.println(map);

        // 해시맵 데이터 삭제
        map.remove("apple");
        System.out.println(map);
    }
}
