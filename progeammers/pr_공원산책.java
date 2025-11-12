package progeammers;

public class pr_공원산책 {
    class Solution {
        public int[] solution(String[] park, String[] routes) {
            int[] answer  = new int[2];
            int x = -1;
            int y = -1;
            int height = park.length;
            int weight = park[0].length();
            for (int i = 0; i < park.length; i++) {
                if (park[i].indexOf('S') != -1){
                    x = park[i].indexOf('S');
                    y = i;
                    break;
                }
            }

            for (int i = 0; i < routes.length; i++) {
                String[] temp = routes[i].split(" ");
                String vector = temp[0];
                int distance = Integer.parseInt(temp[1]);
                int curX = x;
                int curY = y;

                if (vector.equals("E")){
                    boolean flag = true;
                    for (int j = 1; j <= distance; j++){
                        curX++;
                        if (curX >= weight){
                            flag = false;
                            break;
                        } else if (park[curY].charAt(curX)=='X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        x = curX;
                    }
                }
                else if (vector.equals("W")){
                    boolean flag = true;
                    for (int j = 1; j <= distance; j++){
                        curX--;
                        if (curX < 0){
                            flag = false;
                            break;
                        }else if (park[curY].charAt(curX)=='X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        x = curX;
                    }
                }
                if (vector.equals("S")){
                    boolean flag = true;
                    for (int j = 1; j <= distance; j++){
                        curY++;
                        if (curY >= height){
                            flag = false;
                            break;
                        }else if (park[curY].charAt(curX)=='X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        y = curY;
                    }
                }
                if (vector.equals("N")){
                    boolean flag = true;
                    for (int j = 1; j <= distance; j++){
                        curY--;
                        if (curY < 0){
                            flag = false;
                            break;
                        }else if (park[curY].charAt(curX)=='X') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        y = curY;
                    }
                }
            }
            answer[0] = y;
            answer[1] = x;

            return answer;
        }
    }
}