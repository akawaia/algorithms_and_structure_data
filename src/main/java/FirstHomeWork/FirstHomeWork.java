package FirstHomeWork;

import java.io.*;
import java.util.Arrays;

public class FirstHomeWork {


    public static void main(String[] args) {
//        firstTask();
//        secondTask(5, 2);
        thirdTask();
    }

    private static void thirdTask() {
        int numbers = 2;
        File file = new File("src/main/resources/numbers.txt");
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {

            int lengthLess = 0;
            int lengthMore = 0;
            int subtract;
            char[] firstNumber = null;
            char[] secondNumber = null;

            for (int i = 0; i < numbers; i++) {
                if (i == 0) {
                    firstNumber = in.readLine().toCharArray();
                } else secondNumber = in.readLine().toCharArray();
            }

            if (firstNumber.length > secondNumber.length) {
                lengthMore = firstNumber.length;
                lengthLess = secondNumber.length;
            } else {
                lengthMore = secondNumber.length;
                lengthLess = firstNumber.length;
            }

            int[] arrFirstNumber = new int[lengthMore];
            int[] arrSecondNumber = new int[lengthMore];

            Arrays.fill(arrFirstNumber, 0);
            Arrays.fill(arrSecondNumber, 0);

            subtract = lengthMore - lengthLess;

            for (int i = lengthMore - 1; i >= 0; i--) {
                if (i >= firstNumber.length) {
                    for (int j = firstNumber.length - 1; j >= 0; j--) {
                        arrFirstNumber[j + subtract] = firstNumber[j] - '0';
                    }
                    break;
                }
                arrFirstNumber[i] = firstNumber[i] - '0';
            }
            for (int i = lengthMore - 1; i >= 0; i--) {
                if (i >= secondNumber.length) {
                    for (int j = secondNumber.length - 1; j >= 0; j--) {
                        arrSecondNumber[j + subtract] = secondNumber[j] - '0';
                    }
                    break;
                }
                arrSecondNumber[i] = secondNumber[i] - '0';
            }
            int[] result = new int[lengthMore + 1];
            for (int i = lengthMore - 1; i >= 0; i--) {
                if (arrFirstNumber[i] + arrSecondNumber[i] > 9) {
                    result[i + 1] = (arrFirstNumber[i] + arrSecondNumber[i]) - 10;
                    if (i != 0) arrFirstNumber[i - 1] += 1;
                    else result[i] += 1;
                } else result[i + 1] = arrFirstNumber[i] + arrSecondNumber[i];
            }

            try(BufferedWriter out = new BufferedWriter(new FileWriter(file,true))) {
                String resultStr = "\n" + Arrays.toString(result).replaceAll("\\[|\\]|,|\\s", "");
                out.write(resultStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void secondTask(int row, int column) {
        //        Требуется написать метод, принимающий на вход размеры двумерного массива и выводящий массив
        //        в виде инкременированной цепочки чисел, идущих по спирали
        int[][] arr = new int[row][column];
        int k = 1;
        int x = 1;
        int y = 1;
        boolean right = true;
        boolean down = false;
        boolean left = false;
        boolean up = false;

        if (row == 1) {
            for (int i = 0; i < column; i++) {
                arr[0][i] = k;
                k++;
            }
        } else {
            for (int i = 0; i < column; i++) {
                arr[0][i] = k;
                k++;
            }
            for (int i = 1; i < row; i++) {
                arr[i][column - 1] = k;
                k++;
            }
            for (int i = column - 2; i >= 0; i--) {
                arr[row - 1][i] = k;
                k++;
            }
            for (int i = row - 2; i > 0; i--) {
                arr[i][0] = k;
                k++;
            }


            while (k != (row * column) + 1) {
                if (right) {
                    while (arr[x][y] == 0) {//движение вправо
                        arr[x][y] = k;
                        k++;
                        y++;
                        if (arr[x][y] != 0) {
                            y--;
                            x++;
                            right = false;
                            down = true;
                            break;
                        }
                    }
                }
                if (down) {
                    while (arr[x][y] == 0) {//Движение вниз
                        arr[x][y] = k;
                        k++;
                        x++;
                        if (arr[x][y] != 0) {
                            x--;
                            y--;
                            down = false;
                            left = true;
                            break;
                        }
                    }
                }
                if (left) {
                    while (arr[x][y] == 0) {//Движение влево
                        arr[x][y] = k;
                        k++;
                        y--;
                        if (arr[x][y] != 0) {
                            x--;
                            y++;
                            left = false;
                            up = true;
                            break;
                        }
                    }
                }
                if (up) {
                    while (arr[x][y] == 0) {//Движение вверх
                        arr[x][y] = k;
                        k++;
                        x--;
                        if (arr[x][y] != 0) {
                            x++;
                            y++;
                            up = false;
                            right = true;
                            break;
                        }
                    }
                }
            }
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void firstTask() {
        //    1. Простые делители числа 13195 - это 5, 7, 13 и 29. Каков самый большой делитель числа 600851475143,
        //    являющийся простым числом? Проверить ответ можно здесь(нужна регистрация)

        long number = 600851475143L;
        for (long i = 2; i < number; i++) {
            if (number % i == 0) {
                number /= i;
            }
        }
        System.out.println(number);
    }
}

