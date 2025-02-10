package basic.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Test3 {
    public static void main(String[] args) {
        // 사용자 정의 클래스를 stack, queue 활용

        // stack
//        {
//            Deque<Node> stack = new ArrayDeque<Node>();
//            stack.push(new Node(3, 0, 4));
//            stack.push(new Node(2, 8, 1));
//            stack.push(new Node(1, 6, 3));
//            stack.push(new Node(5, 5, 10));
//
//            System.out.println(stack.pop());
//            System.out.println(stack.peek());
//
//            stack.push(new Node(9, 0, 3));
//
//            while (!stack.isEmpty()) {
//                System.out.print(stack.pop() + " ");
//            }
//        }

        // queue
        {
            Queue<Node> queue = new ArrayDeque<>();
            queue.offer(new Node(3, 0, 4));
            queue.offer(new Node(2, 8, 1));
            queue.offer(new Node(1, 6, 3));
            queue.offer(new Node(5, 5, 10));

            System.out.println(queue.poll());
            System.out.println(queue.peek());

            queue.offer(new Node(9, 0, 3));

            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
        }
    }

    // 현재 노드의 좌표 (x, y) 와 이 노드까지의  비용
    static  class Node{
        int y, x, c;
        Node (int y, int x, int c){
            this.y = y;
            this.x = x;
            this.c = c;
        }

        @Override
        public String toString(){
            return "(" + y + ", " + x + ", " + c + ")";
        }

    }
}
