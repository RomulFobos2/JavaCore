import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void fuzzySearchTest_1() {
        boolean result = true;
        Assert.assertEquals("Результат поиска должен быть - true", result, Main.fuzzySearch("car", "ca6$$#_rtwheel"));
    }

    @Test
    public void fuzzySearchTest_2() {
        boolean result = true;
        Assert.assertEquals("Результат поиска должен быть - true", result, Main.fuzzySearch("cwhl", "cartwheel"));
    }

    @Test
    public void fuzzySearchTest_3() {
        boolean result = true;
        Assert.assertEquals("Результат поиска должен быть - true", result, Main.fuzzySearch("cwhee", "cartwheel"));
    }

    @Test
    public void fuzzySearchTest_4() {
        boolean result = true;
        Assert.assertEquals("Минимальное значение должно быть = 0", result, Main.fuzzySearch("cartwheel", "cartwheel"));
    }

    @Test
    public void fuzzySearchTest_5() {
        boolean result = false;
        Assert.assertEquals("Результат поиска должен быть - false", result, Main.fuzzySearch("cwheeel", "cartwheel"));
    }

    @Test
    public void fuzzySearchTest_6() {
        boolean result = false;
        Assert.assertEquals("Результат поиска должен быть - false", result, Main.fuzzySearch("lw", "cartwheel"));
    }
}
