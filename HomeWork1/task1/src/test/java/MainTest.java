
import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    int[][] testArray = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8}};

    @Test
    public void findMin() {
        int result = 0;
        Assert.assertEquals("Минимальное значение должно быть = 0", result, Main.findMin(testArray));
    }

    @Test
    public void findMax() {
        int result = 8;
        Assert.assertEquals("Максимальное значение должно быть = 8", result, Main.findMax(testArray));
    }

    @Test
    public void findMiddleValue() {
        double result = 4.0;
        Assert.assertEquals("Среднее значение должно быть = 4.0", result, Main.findMiddleValue(testArray), 0);
    }

}
