package basic.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BufferedReaderTest {
    public static void main(String[] args) throws Exception {
        // BufferedReader ( InputStreamReader())
        //처리 코드는 Scanner 에 비해서 다소 복잡하지만, 매우 빠른 성능을 보장

        //1 2 3 4 5
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str = br.readLine(); // "1 2 3 4 5
//
//            int[] input = new int[5];
//            StringTokenizer st = new StringTokenizer(str);
//
//            for (int i = 0; i < 5; i++) {
//                input[i] = Integer.parseInt(st.nextToken());
//            }
//
//            System.out.println(Arrays.toString(input));
//        }

        // 1 A 3 B 5
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine(); // 1 A 3 B 5

            char[] input = new char[5];
            StringTokenizer st = new StringTokenizer(str);

            for (int i = 0; i < 5; i++) {
                input[i] = st.nextToken().charAt(0);
            }

            System.out.println(Arrays.toString(input));
        }
    }
}
