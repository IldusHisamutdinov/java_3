package lesson8;

public class MainClass {
    public static void main(String[] args) {

        //Проверка задачи на спиральное заполнение массива
        SpiralFilling spiralArray = new SpiralFilling(5);
        spiralArray.make();
        spiralArray.display();
    }
}