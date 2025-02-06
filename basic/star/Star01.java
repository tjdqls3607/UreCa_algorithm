package basic.star;

public class Star01 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {   // 행
            for (int j = 0; j < i; j++) {   // 열
                System.out.print(" ");
            }
            for (int k = 5; k > i; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
