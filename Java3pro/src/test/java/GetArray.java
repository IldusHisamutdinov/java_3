import lesson6.ArrayClass;
/*
 * Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
 * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
 * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
 * иначе в методе необходимо выбросить RuntimeException.
 * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 * Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 */
import org.junit.*;

public class GetArray {
    private ArrayClass arrayClass;

    @Before
    public void init() {
        arrayClass = new ArrayClass();
    }

    @Test(expected = RuntimeException.class)
    public void testException() {
        System.out.println("В массиве нет 4!");
        int[] one = new int[]{1, 1, 9, 0, 2, 3, 5, 6, 7, 8, 9};
        Assert.assertArrayEquals(new int[]{7, 8, 9}, arrayClass.getValuesFromArray(one));
    }

    @Test
    public void testFirst() {
        Assert.assertArrayEquals(arrayClass.getValuesFromArray(new int[]{1, 1, 1, 4, 4, 1, 4, 6, 7, 8, 9}), new int[]{6, 7, 8, 9});
    }

    @Test
    public void testTwo() {
        Assert.assertArrayEquals(arrayClass.getValuesFromArray(new int[]{1, 4, 24, 4, 8, 9}), new int[]{8, 9});
    }

    @Test
    public void testThree() {
        Assert.assertArrayEquals(arrayClass.getValuesFromArray(new int[]{4, 4, 4, 1, 2, 3}), new int[]{1, 2, 3});
    }
}
