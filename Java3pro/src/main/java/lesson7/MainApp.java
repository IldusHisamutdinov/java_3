package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainApp {
    public static void main(String[] args)  {
        Class testClass = TestClass.class;
        start(testClass);
    }

    public static void start(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        int beforeExist = 0, beforeNumber = 0, afterExist = 0, afterNumber = 0;

        System.out.println("Проверка наличия аннотаций");
        for (int i = 0; i < methods.length; i++){
            beforeExist += (methods[i].isAnnotationPresent(BeforeSuite.class))?1:0;
            if(methods[i].isAnnotationPresent(BeforeSuite.class)) beforeNumber = i;
            afterExist += (methods[i].isAnnotationPresent(AfterSuite.class))?1:0;
            if(methods[i].isAnnotationPresent(AfterSuite.class)) afterNumber = i;
            if ((beforeExist > 1 || afterExist > 1)){
                throw new RuntimeException("Дублирование аннотаций BeforeSuite/AfterSuite");
            }
        }
        System.out.println("Проверка аннотаций закончена");

        try{
            System.out.println("Выполнение тестов");
            methods[beforeNumber].invoke(null);
            for (int priority = 1; priority <= 10 ; priority++) {
                System.out.println("Выполняем приоритет " + priority);
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Test.class)) {
                        if (method.getAnnotation(Test.class).priority() == priority) {
                            method.invoke(null);
                        }
                    }
                }
            }
            methods[afterNumber].invoke(null);
        } catch (IllegalAccessException | InvocationTargetException error) {
            error.printStackTrace();
        }
    }
}

