package lesson3;

import java.io.*;
import java.util.*;


public class less3 {
//    public less3() throws UnsupportedEncodingException, FileNotFoundException {
//    }

    public static void main(String[] args) throws IOException {


        //1.Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль
        try (
                FileInputStream in = new FileInputStream("123/2.txt")) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int ax;
            while ((ax = in.read()) != -1) {
                out.write(ax);
            }
            byte a[] = out.toByteArray();
            for (int i = 0; i < a.length; i++) {
                System.out.print((char) a[i] + " ");
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        System.out.println(" ");
        System.out.println("=======================");
/*
2.Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
*/
        ArrayList<InputStream> al = new ArrayList<>();

        al.add(new FileInputStream("123/11.txt"));
        al.add(new FileInputStream("123/22.txt"));
        al.add(new FileInputStream("123/33.txt"));

        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(al));
        DataOutputStream out = new DataOutputStream(new FileOutputStream("123/rnd.txt"));
        int xa;
        while ((xa = in.read()) != -1) {
            out.write(xa);
            System.out.print((char) xa);
        }
        in.close();
        out.close();

        System.out.println(" ");
        System.out.println("=======================");
/*
Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
Контролируем время выполнения:
программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
 */
        int s = 18; // страница, с которой нужно открыть, всего 28
        long t = System.currentTimeMillis();
        RandomAccessFile raf = new RandomAccessFile("123/1.txt", "r");
        int x = 1927; // количество знаков на странице
        int r = (s - 1); //открывается  страница
        raf.seek(r * x);
        int i;
        while ((i = raf.read()) != -1) {
            System.out.print((char) i);
        }
        raf.close();
        System.out.println();
        System.out.println(System.currentTimeMillis() - t);


    }
}