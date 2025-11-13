package practice;

public class method {
    public static void main(String[] args) {
        int ret = add(5,5); // add() 라는 함수에 5와 5를 넣어서 함수 실행 후 호출
        System.out.println(ret);
    }
    public static int add(int a, int b) {
        int result = a + b;
        return result;
    }
}
