package basic.sort;

import java.util.Arrays;
import java.util.Collections;

public class ArraySortTest {
    public static void main(String[] args) {

//        int[] intArray = {3, 5, 2, 7, 9, 4};
//
//        System.out.println(Arrays.toString(intArray));
//        Arrays.sort(intArray);
//        System.out.println(Arrays.toString(intArray));
//
//        // String
//        String[] strArray = {"Hello", "ABC" , "World", "Uplus"};
//        System.out.println(Arrays.toString(strArray));
//        Arrays.sort(strArray);
//        System.out.println(Arrays.toString(strArray));
//        Arrays.sort(strArray, Collections.reverseOrder());
//        System.out.println(Arrays.toString(strArray));

        // 사용자 정의 클래스
        Item[] itemArray = {new Item(3, "66"), new Item(2, "77"), new Item(5, "44"), new Item(8, "11")};
        Arrays.sort(itemArray);
        System.out.println(Arrays.toString(itemArray));
    }
    // 객체들을 정렬할 때 기준이 필요, 이 기준을 여러가지 존재
    // #1 클래스에 정의
    static class Item implements Comparable<Item> {
        int itemId;
        String itemName;

        Item(int itemId, String itemName) {
            this.itemId = itemId;
            this.itemName = itemName;
        }

        @Override
        public String toString() {
            return "Item [ itemId=" + itemId + ", itemName=" + itemName + "]";
        }

        @Override
        public int compareTo(Item o) {  // 정렬 기준 제공
//            return o.itemId - this.itemId;  // natural ordering
//            return this.itemId - o.itemId;  // natural ordering
            return  this.itemName.compareTo(o.itemName);
            // itemId 우선 비교 두개가 같으면 itemName 으로 비교하도록
        }
    }
}
