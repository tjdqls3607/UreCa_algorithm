package basic.array;

public class Array1 {
    public static void main(String[] args) {
        // #1 주어진 배열의 원소들 중 제시된 규칙과 다른 항목이 몇 건?
        // 맨 앞부터 3개 씩 묶어서 곱셈 결과가 맞으면 통과 틀리면 wrongCnt 증가
        // 3,2,6 : 3x2 = 6 통과
        // 3,4,4 : 3X4 = 12 != wrongCnt
        {
            int[] intArr = {3,2,6, 3,4,4, 1,4,2, 2,3,6, 1,3,5, 1,5,1, 1,1,1, 2,4,2, 2,2,4};
            int wrongCnt = 0;
            // 구현
            int intLength = intArr.length - 2;
            for (int i = 0; i <intLength; i=i+3) {
                if (intArr[i] * intArr[i+1] != intArr[i+2]) {
                    wrongCnt++;
                }
            }
            System.out.println(wrongCnt);
        }

        // #2 양 끝에서 출발해서 안쪽으로 이동하면서 각 대칭 항목이 다른 건 몇 건?
        // 맨 앞부터 3개 씩 묶어서 곱셈 결과가 맞으면 통과 틀리면 wrongCnt 증가
        // 3,2,6 : 3x2 = 6 통과
        // 3,4,4 : 3X4 = 12 != wrongCnt
        {
            char[] charArray = "XYZEBFFGQOVVPWGFFCEAYX".toCharArray();
            int wrongCnt = 0;
            // 구현
            int center = charArray.length / 2;
            for (int i = 0 , r = charArray.length - 1; i < center; i++, r--) {
                if (charArray[i] != charArray[r]) {
                    wrongCnt++;
                }
            }

            System.out.println(wrongCnt);
        }

        // #3. 문자열에 포함된 알파벳의 빈도수 출력, 0인 항목도 출력
        {
            String str = "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi";

            // 모든 알파벳 소문자가 몇번 반복되었는지 출력
            // a : 4
            // b : 2
            // ....

            // 빈도수 관리 배열
            int[] alphaCnt = new int[26];   //해당 알파벳 - 'a'
            // 문자열을 char 배열로 변경 가능. String.charAt() 이용
            int strlen = str.length();
            for (int i = 0; i < strlen; i++) {
                alphaCnt[str.charAt(i) - 'a']++;
            }

            //출력
            for (int i = 0; i < 26; i++) {
                System.out.println((char)(i + 'a') + ":" +alphaCnt[i]);
            }

        }
    }
}
