package practice;

import java.util.ArrayList;

public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        ArrayList<Integer> list2 = new ArrayList<>(list); //list 를 메개변수로 가져와서 사용
        System.out.println(list2);
        System.out.println(list2.get(1));  //get 을 사용해서 list내의 데이터 하나에 접근
        list2.remove(list2.size()-1);   // list의 마지막 데이터를 삭제
        list2.remove(list2.size()-2);  // list의 마지막에서 2번째 데이터를 삭제
        System.out.println(list2);
    }
}
