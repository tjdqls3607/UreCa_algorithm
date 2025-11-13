package practice;

public class early_return {
    public static void main(String[] args) {
        System.out.println(totalPrice(4, 50));
    }
    static int totalPrice(int quantity, int price) {
        int total = quantity * price;   // total 이라는 정수형 변수에 수량과 가격 곱하기
        if (total > 100) {  // total 이 100 보다 큰 경우
            return (int)(total * 0.9); // total 에 0.9를 곱하여 조기에 종료
        }
        return total;
    }
}
