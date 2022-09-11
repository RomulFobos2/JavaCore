
import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    int[] testArray = {3, 6, 5, 6, 4, 2, 1, 7};

    @Test
    public void quickSortAsc() {
        int[] result = {1, 2, 3, 4, 5, 6, 6, 7};
        Main.quickSort(testArray, 0, testArray.length-1, true);
        Assert.assertArrayEquals("Массив отсортированный по возрастанию = ", result, testArray);
    }

    @Test
    public void quickSortDes() {
        int[] result = {7, 6, 6, 5, 4, 3, 2, 1};
        Main.quickSort(testArray, 0, testArray.length-1, false);
        Assert.assertArrayEquals("Массив отсортированный по убыванию = ", result, testArray);
    }
}