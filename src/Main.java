import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Bishkek");
        list.add("Talas");
        list.add("Osh");
        list.add("Naryn");
        list.add("Cholpon-Ata");
        list.add("Jalal-Abad");

        MyArrayList<String> listTwo = new MyArrayList<>();
        listTwo.add("Naryn");
        listTwo.add("Cholpon-Ata");
        listTwo.add("Bishkek");

        System.out.println(list.remove("Bishkek"));
        System.out.println(list);
    }
}
