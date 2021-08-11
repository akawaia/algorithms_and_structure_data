package FifthHomeWork.FirstTask;

public class FirstTask {
    public static void main(String[] args) {
        System.out.println(numberPower(3, 3));
    }

    private static int numberPower(int number, int power) {
        if (power == 1) return number;
        int result = number * numberPower(number, power - 1);
        return result;
    }
}
