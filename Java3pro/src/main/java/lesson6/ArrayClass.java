package lesson6;

public class ArrayClass {

    public int[] getValuesFromArray(int[] array) {
        int var = 0;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] == 4) {
                var = i;
                break;
            }
        }
        if (var == 0) throw new RuntimeException("В массиве нет 4!");
        int[] newArray = new int[array.length - 1 - var];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[var + i + 1];
        }
        return newArray;
    }

    public boolean testArray(int[] array) {
        boolean result = true;
        boolean a = false;
        boolean b = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1)
                a = (array[i] == 1);
            if (array[i] == 4)
                b = (array[i] == 4);
            result &= ((array[i] == 1) || (array[i] == 4));
        }
        return result & a & b;
    }
}

/*       System.out.print((ii * 2 == jj) ^ (jj / 2 == ii)? "yes " : "no ");
        При выполнении любых арифметических операций (умножение, деление, ...)
        объекты классов-оболочек (Integer) автоматически разворачиваются
        в значения примитивного типа (int). Результатом любой арифметической операции
        также будет значение примитивного типа. Если с помощью == сравниваются
        значение примитвного типа и объект-оболочка, то объект автоматически разворачивается,
        и происходит сравнение двух примитивов.
          Операция XOR — это логическое сложение по модулю два, также данную операцию называют исключающее или,
          очевидно, что оно истинно когда оба аргумента различны.
        Результатом операции ^ (исключающее ИЛИ) будет false, так как оба операнда true.
        Boolean a |	Boolean b |	a ^ b
        true	  |  true	  | false
        true	  |  false	  | true
        false	  |  true	  | true
        false	  |  false	  | false
*/