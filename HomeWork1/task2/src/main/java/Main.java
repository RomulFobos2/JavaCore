import java.util.Arrays;

public class Main {

    /*
    2. Отсортируйте массив [5,6,3,2,5,1,4,9]
     */
    public static void main(String[] args) {
        int[] workArray = {5, 6, 3, 2, 5, 1, 4, 9};
        System.out.println("Исходный массив = " + Arrays.toString(workArray));
        quickSort(workArray, 0, workArray.length - 1, true);
        System.out.println("Массив отсортирован по возрастанию = " + Arrays.toString(workArray));
        quickSort(workArray, 0, workArray.length - 1, false);
        System.out.println("Массив отсортирован по убыванию = " + Arrays.toString(workArray));
    }

    /*
        Сортируем массив методом "Быстрой сортировки"
        order - true - по возрастнаию, false - по убыванию
     */
    public static void quickSort(int[] array, int low, int height, boolean order) {
        if (array.length == 0 | low >= height) {
            return;
        }
        int middleElement = array[(low + height) / 2];
        int i = low;
        int j = height;

        while (i <= j) {
            if (order){
                while (array[i] < middleElement) {
                    i++;
                }
                while (array[j] > middleElement) {
                    j--;
                }
            }
            else {
                while (array[i] > middleElement) {
                    i++;
                }
                while (array[j] < middleElement) {
                    j--;
                }
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }

        }

        if (low < j) {
            quickSort(array, low, j, order);
        }

        if (height > i) {
            quickSort(array, i, height, order);
        }
    }
}
