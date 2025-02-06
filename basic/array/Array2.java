package basic.array;

public class Array2 {
    // Circular Array
    public static void main(String[] args) {
        char[] input = {'A','B','C','D','E','F', 'G'};
        int len = input.length;

        //전체 길이의 2배 순회 출력
        {
            for (int i = 0; i < len*2; i++) {
                System.out.print(input[i % len] + " ");
            }
            System.out.println();
        }
    }
}
