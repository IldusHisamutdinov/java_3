package lesson8;
public class SpiralFilling {
    private int size;
    private int[][] array;

    public SpiralFilling(int size) {
        this.size = size;
        this.array = new int[size][size];
    }

    public void make() {
        int k = 1;

        //Теперь заполняем внутреннюю часть
        int tmp = 0;
        int i = 0;
        int j = 0;

        //Горизонталь верх
        while (true) {
            while (j < (size - tmp)) {
                if (k > (size * size)) return;
                array[i][j] = k++;
                j++;
            }

            //Вертикаль справа
            j--;
            i++;
            while (i < (size - tmp)) {
                if (k > (size * size)) return;
                array[i][j] = k++;
                i++;
            }

            //Горизонталь снизу
            i--;
            j--;
            while (j >= tmp) {
                if (k > (size * size)) return;
                array[i][j] = k++;
                j--;
            }

            //Вертикаль справа
            j++;
            i--;
            tmp++;
            while (i >= tmp) {
                if (k > (size * size)) return;
                array[i][j] = k++;
                i--;
            }
            i++;
            j++;
        }
    }

    public void display() {
        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j ++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}