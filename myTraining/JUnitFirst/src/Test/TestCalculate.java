package Test;

import Calculation.Calculate;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.lang.ArithmeticException;

public class TestCalculate {
    private static Calculate c;

    @Rule
    public final ExpectedException exp = ExpectedException.none();

    @AfterClass
    public static void finish(){
        System.out.println("fnish");
    }

    @BeforeClass
    public static void createObject(){
        c = new Calculate();
        System.out.println("start");
    }

    @Test
    public void testAdd(){
        double res = c.add(6.0, 3.0);
        Assert.assertTrue(res == 9.0);
        Assert.assertNotNull(c);
    }

    @Ignore
    @Test
    public void testDeduct(){
        double res = c.deduct(6.0, 3.0);
        Assert.assertTrue(res == 3.0);
    }

    @Test
    public void testMultiply(){
        double res = c.multiply(6.0, 3.0);
        Assert.assertTrue(res == 18.0);
    }

    @Test
    public void testDivide(){
        double res = c.divide(6.0, 3.0);
        Assert.assertTrue(res == 2.0);
    }

//    @Test(expected = ArithmeticException.class)
    @Test
    public void isExcept(){
        exp.expect(ArithmeticException.class);
        c.divide(5.0,0.0);
    }

    @Test(timeout = 1000)
    public void testN(){
      //  while(true){}

        c.add(1 ,1);
    }
}
