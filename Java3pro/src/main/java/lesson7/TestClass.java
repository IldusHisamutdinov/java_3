package lesson7;

public class TestClass {
    @AfterSuite
    public static void testAfter (){
        System.out.println("After test");
    }

    @Test(priority = 1)
    public static void testPriority1 (){
        System.out.println("Test priority 1");
    }

    @Test(priority = 1)
    public static void testPriority12 (){
        System.out.println("Test priority 12");
    }

    @Test(priority = 5)
    public static void start3 (){
        System.out.println("Test priority 5");
    }

    @BeforeSuite
    public static void testAfter2 (){
        System.out.println("Before test");
    }

}
