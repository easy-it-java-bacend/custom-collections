import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(3, 0);

        ArrayListForInt arrayListForInt = new ArrayListForInt();
        arrayListForInt.add(12);
        arrayListForInt.add(121);
        arrayListForInt.add(2);
        arrayListForInt.add(0,1);
        arrayListForInt.add(5);

        for (int i = 0; i < arrayListForInt.size(); i++) {
            System.out.println(arrayListForInt.get(i));
        }
    }
}
