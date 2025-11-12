package progeammers;

public class pr_바탕화면정리 {
    class Solution {
        public int[] solution(String[] wallpaper) {
            int minx = wallpaper.length; // x 최소값
            int maxx = 0;
            int miny = wallpaper[0].length(); //y 최소값
            int maxy = 0;
            for(int i = 0; i < wallpaper.length; i++){
                if(wallpaper[i].contains("#")){
                    if(minx>i) minx = i;
                    if(maxx<i) maxx = i;
                }
                for(int j = 0; j < wallpaper[i].length(); j++){
                    if(wallpaper[i].charAt(j)=='#'){
                        if(miny>j) miny = j;
                        if(maxy<j) maxy = j;
                    }
                }
            }
            return new int[]{minx,maxx+1,miny,maxy+1};
        }
    }
}
