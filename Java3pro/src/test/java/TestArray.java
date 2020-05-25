import lesson6.ArrayClass;
/*
* Написать метод, который проверяет состав массива из чисел 1 и 4.
* Если в нем нет хоть одной четверки или единицы, то метод вернет false;
* Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestArray {
    private int[] arr;
    private boolean b;
    private ArrayClass arrayClass;

    public TestArray(int[] arr, boolean b) {
        this.arr = arr;
        this.b = b;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 1, 4, 4, 1, 4, 4}, true},
                {new int[]{1, 1, 1, 1, 1, 1}, false},
                {new int[]{4, 4, 4, 4}, false},
                {new int[]{1, 1, 4, 4, 4, 3}, false},
        });
    }

    @Before
    public void init() {
        arrayClass = new ArrayClass();
    }

    @Test
    public void testArray() {
        Assert.assertEquals(arrayClass.testArray(arr), b);
    }

}