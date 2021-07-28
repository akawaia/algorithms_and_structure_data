package Second_HomeWork;

public class Note_generator {
    private final static int rankNumberPrice = 100;

    private final static int stepPrice = 100;
    private final static int maxPrice = 1000;
    private final static int minPrice = 500;
    private final static int priceArrLength = (maxPrice - minPrice + stepPrice) / rankNumberPrice;
    private static int[] price_array = new int[priceArrLength];

    private final static int stepRam = 4;
    private final static int maxSizeRam = 12;
    private final static int minSizeRam = 4;
    private final static int ramArrLength = (maxSizeRam) / stepRam;
    private static int[] ram_array = new int[ramArrLength];

    private final static String[] brand = {"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};

    public static void noteGenerator(Notebook[] arrays) {
        priceGenerate(price_array);
        ramGenerate(ram_array);
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = new Notebook(price_array[(int) (Math.random() * priceArrLength)], ram_array[(int) (Math.random() * ramArrLength)], brand[(int)
                    (Math.random() * brand.length)]);
        }
    }

    private static void priceGenerate(int[] price_array) {
        for (int p = minPrice, i = 0; p <= maxPrice; i++, p += stepPrice) {
            price_array[i] = p;
        }
    }

    private static void ramGenerate(int[] ram_array) {
        for (int r = minSizeRam, i = 0; r <= maxSizeRam; r += stepRam, i++) {
            ram_array[i] = r;
        }
    }

}
