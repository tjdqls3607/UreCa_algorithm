package basic.recursive;

public class Test {
    public static void main(String[] args) {
//        m1();
//        m1_param(0);
//        m2();
//        m3();
        m4(5);  //반복횟수 5 전달
    }

    //// 변수
    static int m1_i = 0;
    static void m1() {
        // local 변수 <= 재귀호출마다 스택에 새로 만들어지고 초기화 된다.
//        int i = 0;
//        System.out.println("m1()" + i++);

        // static 변수 <= 재귀호출마다 공유
        System.out.println("m1() " + m1_i++);
        m1();
    }

    static void m1_param(int i) {
        // 파라미터 변수 <= 재귀호출마다 스택에 새로 만들어지고 이전 호출에서 전달된 값을 복사
        System.out.println("m1_param() " + i++);
        m1_param(i);
    }

    //// 기저 조건
    static  int m2_cnt = 5;
    static void m2() {
        System.out.println("앞 m2() " + m2_cnt);
        // 기저조건
        if (m2_cnt > 0) {
            m2_cnt--;
            m2();
        }
        System.out.println("뒤 m2() " + m2_cnt);

    }

    // 5번 호출
    static  int m3_cnt = 5;
    static void m3() {
        // 기저조건
        if (m3_cnt == 0) return;

        System.out.println("앞 m3() " + m3_cnt);

        m3_cnt--;
        m3();
        m3_cnt++;   // 이 코드가 없으면 static 변수 m3_cnt가 0으로 감소한 후 계속 0 으로 유지, 원상복구가 필요함

        System.out.println("뒤 m3() " + m3_cnt);

    }

    static void m4(int m4_cnt) {
        // 기저조건
        if (m4_cnt == 0) return;

        System.out.println("앞 m4() " + m4_cnt);

//        m4_cnt--;
//        m4(m4_cnt);
//        m4_cnt++;   // 이 코드가 없으면 static 변수 m3_cnt가 0으로 감소한 후 계속 0 으로 유지, 원상복구가 필요함

//        m4(m4_cnt - 1); // 호출 시 전달받은 m4_cnt는 변화 X
//        m4(m4_cnt--);   // 5 가 전달 -> 스택 오버 플로우 발생
        m4(--m4_cnt);   //호출 시 전달받은     m4_cnt가 1 감소
        m4_cnt++;   // 원복 필요


        System.out.println("뒤 m4() " + m4_cnt);

    }
}
