package basic.stackqueue;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        // Queue
        // stack
//        {
//            Queue<Integer> queue = new LinkedList<>();
//
//            queue.offer(3);
//            System.out.println(queue.peek());
//            System.out.println(queue.size());
//
//            queue.offer(1);
//            System.out.println(queue.peek());
//            System.out.println(queue.size());
//
//            queue.offer(7);
//            System.out.println(queue.peek());
//            System.out.println(queue.size());
//
//            Integer num = queue.poll();
//            System.out.println(num);
//            System.out.println(queue.peek());
//            System.out.println(queue.size());
//
//            while (!queue.isEmpty()) {
//                System.out.print(queue.poll() + " ");
//            }
//        }

        // Queue using ArrayDeque
        {
            Queue<Integer> queue = new ArrayDeque<>();

            queue.offer(3);
            System.out.println(queue.peek());
            System.out.println(queue.size());

            queue.offer(1);
            System.out.println(queue.peek());
            System.out.println(queue.size());

            queue.offer(7);
            System.out.println(queue.peek());
            System.out.println(queue.size());

            Integer num = queue.poll();
            System.out.println(num);
            System.out.println(queue.peek());
            System.out.println(queue.size());

            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
        }
    }
}
