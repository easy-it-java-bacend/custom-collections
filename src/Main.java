import util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < 100; i++) {
            queue.offer((int)(1 + Math.random() * 199));
        }
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.poll());
        }
    }
}
