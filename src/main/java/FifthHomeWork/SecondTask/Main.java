package FifthHomeWork.SecondTask;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private final static ObjectForSecondTask[] object = {
            new Apple(4, 10, "Apple"),
            new TV(11, 30, "TV"),
            new Phone(4, 25, "Phone"),
            new Clock(5, 15, "Clock")
    };
    private static final int weightBack = 18;
    private static ArrayList<ObjectForSecondTask> full = new ArrayList<>(Arrays.asList(object));
    private static ArrayList<ObjectForSecondTask> notEmpty = new ArrayList<>();
    private static ArrayList<ObjectForSecondTask> empty = new ArrayList<>();


    public static void main(String[] args) {
        search(full.size());
    }

    private static void search(int length) {

        int weight = 0;
        int priceEmpty = 0;
        int priceNotEmpty = 0;

        for (int i = 0; i < length; i++) {
            notEmpty.add(full.get(i));
            weight += full.get(i).getWeight();
        }
        if (length == object.length && weight <= weightBack) return;
        if (weight > weightBack) {
            notEmpty.clear();
        }
        if (weight <= weightBack) {
            if (empty.isEmpty()){
                return;
            }
            for (int i = 0; i < length; i++) {
                priceNotEmpty += notEmpty.get(i).getPrice();
                priceEmpty += empty.get(i).getPrice();
            }
            if (priceNotEmpty > priceEmpty){
                empty = notEmpty;
                notEmpty.clear();
            }

            System.out.println("EMPTY" + empty);
        }
        for (int i = 0; i < length; i++) {
            search(length - 1);
            rotate();
        }

    }

    private static void rotate() {
    ObjectForSecondTask temp = full.get(0);
    full.remove(0);
    full.add(temp);
        System.out.println("ROTATE" + full);
    }



}

