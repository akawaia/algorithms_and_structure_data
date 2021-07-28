package Second_HomeWork;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Голуби {

    private final static String[] brandName = {"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};

    public static void sort(Notebook arr[]) {
        int n = arr.length;
        int minPrice = arr[0].getPrice();
        int maxPrice = arr[0].getPrice();
        int minRam = arr[0].getRAM();
        int maxRam = arr[0].getRAM();
        int rangePrice, rangeRam, i, j, index;

        for (int a = 0; a < n; a++) {
            if (arr[a].getPrice() > maxPrice) {
                maxPrice = arr[a].getPrice();
            }
            if (arr[a].getPrice() < minPrice) {
                minPrice = arr[a].getPrice();
            }
            if (arr[a].getRAM() > maxRam) {
                maxRam = arr[a].getRAM();
            }
            if (arr[a].getRAM() < minRam) {
                minRam = arr[a].getRAM();
            }
        }

        rangePrice = maxPrice - minPrice + 1;
        rangeRam = maxRam - minRam + 1;

        int[] tempPrice = new int[rangePrice];
        Arrays.fill(tempPrice, 0);
        int[] tempRam = new int[rangeRam];
        Arrays.fill(tempRam, 0);

        for (i = 0; i < n; i++) {
            tempPrice[arr[i].getPrice() - minPrice]++;
            tempRam[arr[i].getRAM() - minRam]++;
        }

        index = 0;
        for (j = 0; j < rangePrice; j++) while (tempPrice[j]-- > 0) arr[index++].setPrice(j + minPrice);

        index = 0;
        for (j = 0; j < rangeRam; j++) while (tempRam[j]-- > 0) arr[index++].setRAM(j + minRam);


//        for (int k = 0; k < n - 1; k++) {
//            if (arr[k].getPrice() == arr[k + 1].getPrice()){
//                if (arr[k].getRAM() == arr[k+1].getRAM()){
//                    Arrays.sort(arr, (o1, o2) -> o1.getBrand().compareTo(o2.getBrand()));
//                }
//            }
//            else return;
//        }

    }
}