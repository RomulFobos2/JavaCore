import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {

    /*
    1. Заполните двумерный массив случайным числами и выведите максимальное, минимальное и среднее значение.
     */
    public static void main(String[] args) {
        int[][] workArray = createArray(5, 3);
        arrayInfo(workArray);
    }

    /*
        Создаем двумерный массив. Если countLines или countColumns == 0 или <, то присваиваем им случайную величину в диапазоне от 5 до 20
        countLines - кол-во строк
        countColumns - кол-во столбцов
     */
    public static int[][] createArray(int countLines, int countColumns) {
        countLines = countLines == 0 ? (int) (Math.random() * 16) + 5 : countLines;
        countColumns = countColumns == 0 ? (int) (Math.random() * 16) + 5 : countColumns;
        int[][] newArray = new int[countLines][countColumns];
        for (int i = 0; i < countLines; i++) {
            for (int j = 0; j < countColumns; j++) {
                //Заполняем массив случайными целочисленными значениями в диапазоне от 1 до 100
                newArray[i][j] = (int) ((Math.random() * 100) + 1);
            }
        }
        System.out.println("Массив создан. Кол-во строк - " + countLines + " . Кол-во столбцов - " + countColumns);
        for(int i = 0; i < countLines; i++){
            System.out.println(Arrays.toString(newArray[i]));
        }
        return newArray;
    }

    //Выводим инфо о массиве (максимальное, минимаельное и среднее значения)
    public static void arrayInfo(int[][] array) {
        System.out.println("Максимальное значение в массиве = " + findMin(array));
        System.out.println("Минимальное значение в массиве = " + findMax(array));
        DecimalFormat format = new DecimalFormat("###.##");
        System.out.println("Среднее значение в масииве = " + format.format(findMiddleValue(array)));
    }

    //Поиск минимального значения в массиве
    public static int findMin(int[][] array){
        int min = array[0][0];
        for (int i = 1; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++){
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
        }
        return min;
    }

    //Поиск максимального значения в массиве
    public static int findMax(int[][] array){
        int max = array[0][0];
        for (int i = 1; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++){
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    //ПОиск среднего значения в массиве
    public static double findMiddleValue(int[][] array){
        int summa = 0;
        int countElements = 0;
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++){
                summa += array[i][j];
                //Считаю кол-во элементов, что бы посчитать среднее. Можно было бы просто умножить кол-во строк на кол-во столбцов в первой строке,
                //но на случай, если понадобится, чтобы кол-во элементов в каждом массиве было разное, то не потребуется переделывать вычисление среднего ;)
                countElements++;
            }
        }
        double result = summa / (countElements * 1.0f);
        return result;
    }
}
