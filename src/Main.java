import util.MyLinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);

        for (Integer i : myLinkedList) {
            System.out.println(i);
        }
    }
}
