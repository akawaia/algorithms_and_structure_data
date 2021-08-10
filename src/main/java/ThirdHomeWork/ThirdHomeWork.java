package ThirdHomeWork;

public class ThirdHomeWork {

    public static void main(String[] args) {
        test(11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16);

    }

    public static int doTest(int... arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int base = (start + end) / 2;
            if (arr[base] - base == 1) {
                start = base + 1;
            } else {
                end = base - 1;
            }
        }
        return start + 1;
    }

    public static void test(int lostNum, int... arr) {
        System.out.printf("Пропущено: %d, найдено: %d%n", lostNum, doTest(arr));
    }

}
