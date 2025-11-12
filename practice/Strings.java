package practice;

public class Strings {
    public static void main(String[] args) {
//        String string = "He";
//        string += "llo";
//        System.out.println(string);
        // 문자열에서 추가및 삭제시에는 기존객체 수정이 아닌 새로운 객체 반환이다

//        String string = "Hello";
//        string = string.replace("l", ""); // Hello 에서 l에 해당하는 문자를 삭제
//        System.out.println(string);

        //StringBuilder 와 StringBuffer
//        String s = "abc";
//        System.out.println(System.identityHashCode(s));
//        s+="def";
//        System.out.println(System.identityHashCode(s));
//        System.out.println(s);

        // identityHashCode()는 객체 특정 식별값 출력하는 메서드 위 코드 실행시 s가 전부 다르게 나오는데 서로가 다른 객체임을 나타냄
//     long start = System.currentTimeMillis();
//
//     String s = "";
//     for (int i = 1; i <= 1000000; i++) {
//         s += i;
//     }
//     long end = System.currentTimeMillis();
//     System.out.println(((end - start)/1000.0) + " seconds");
     // 191.352초 나옴

        //해당 문제를 해결하기 위해 StringBuilder 사용 StringBuilder 클래스는 mutable함
//        long startTime = System.currentTimeMillis();
//        StringBuilder s = new StringBuilder();
//
//        for (int i = 1; i <= 1000000; i++) {
//            s.append(i);  // StringBuilder는 append씀
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println(((endTime - startTime)/1000.0) + "seconds");
        // 0.055초 걸림

        // StringBuilder 활용
        StringBuilder sb = new StringBuilder();

        sb.append(10);
        sb.append("ABC");
        System.out.println(sb);  // 10ABC
        sb.deleteCharAt(3); // 3번째 인덱스 문자 삭제
        System.out.println(sb); // 10AC
        sb.insert(1,2);  // 1번째 인덱스에 2라는 문자 추가
        System.out.println(sb); // 120AC

    }
}
