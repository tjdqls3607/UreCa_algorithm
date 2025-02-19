package basic.dp;

// 현재 길이를 만들기 위해서 사용할 수 있는 막대는 3가지 ( 1cm 2개, 2cm 1개 )
// 길이가 5인 막대를 만든다면
// ----- 은 ---- 에 1cm 파랑, 1cm의 노랑 사용 (2가지)
// ----- 은 --- 에 2cm 빨강 (1 가지)
// f(5) = f(4)*2 + f(3)
public class 막대연결하기 {

    static int[] memoi = new int[7];
    public static void main(String[] args) {

        memoi[1] = 2;
        memoi[2] = 5;
        for (int i = 3; i < memoi.length; i++) {
            memoi[i] = memoi[i - 1] * 2 + memoi[i - 2];
        }

        System.out.println(memoi[6]);
    }
}
