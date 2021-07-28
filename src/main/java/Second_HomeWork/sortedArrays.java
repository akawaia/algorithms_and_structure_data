package Second_HomeWork;

import java.util.Arrays;

public class sortedArrays {

    private final static int amountNote = 30;
    private final static Notebook[] notebook = new Notebook[amountNote];

    public static void main(String[] args) {
        Note_generator.noteGenerator(notebook);
        int temp = 0;
        Голуби.sort(notebook);


//        do {
//            for (int i = 0; i < notebook.length - 1; i++) {
//                if (notebook[i].getPrice() > notebook[i + 1].getPrice()) {
//                    temp = notebook[i].getPrice();
//                    notebook[i].setPrice(notebook[i + 1].getPrice());
//                    notebook[i + 1].setPrice(temp);
//                    temp = 0;
//                } else if (temp == 0) break;
//            }
//            for (int i = notebook.length - 1; i >= 1; i--) {
//                if (notebook[i].getPrice() < notebook[i - 1].getPrice()) {
//                    temp = notebook[i].getPrice();
//                    notebook[i].setPrice(notebook[i - 1].getPrice());
//                    notebook[i - 1].setPrice(temp);
//                } else if (temp == 0) break;
//            }
//        } while (temp != 0);
        System.out.println(Arrays.toString(notebook));

    }
}
