import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

public class TestTriangle1 {

    // 1а.Проверить, что стороны треугольника больше нуля
    @DataProvider
    public static Object[][] dataForValidation() {
        return new Object[][]{
                {4.0, 2.0, 3.0},
                {3.0, 4.0, 5.0},
                {1.0, 1.0, 1.5}
        };
    }

    @Test(dataProvider = "dataForValidation")
    public void testMoreZero(double a, double b, double c) {
//        assertTrue(a > 0, "Сторона треугольника не больше нуля");
//        assertTrue(b > 0, "Сторона треугольника не больше нуля");
//        assertTrue(c > 0, "Сторона треугольника не больше нуля");
        assertEquals(new Triangle(a,b,c).checkTriangle(),a>0);
        assertEquals(new Triangle(a,b,c).checkTriangle(),b>0);
        assertEquals(new Triangle(a,b,c).checkTriangle(),c>0);
    }

    // 1b.Проверить, что сумма двух сторон треугольника больше третьей
    @Test(dataProvider = "dataForValidation")
    public void testSum(double a, double b, double c) {
//        assertTrue(a + b > c, "Сумма двух сторон треугольника  больше третьей");
//        assertTrue(a + c > b, "Сумма двух сторон треугольника  больше третьей");
//        assertTrue(c + b > a, "Сумма двух сторон треугольника  больше третьей");

        assertEquals(new Triangle(a,b,c).checkTriangle(), a + b > c);
        assertEquals(new Triangle(a,b,c).checkTriangle(), a + c > b);
        assertEquals(new Triangle(a,b,c).checkTriangle(), c + b > a);
    }

    // 1c.Проверить на переполнение
    @DataProvider
    public static Object[][] dataMaxLength() {
        return new Object[][]{//
                {Double.MAX_VALUE, 1.0, 2.1},
                {56.0, Double.MAX_VALUE, 2.198},
                {508.36, 89.13, Double.MAX_VALUE}
        };
    }

    @Test(dataProvider = "dataMaxLength")
    public void testMaxLength(double a, double b, double c) {
        assertEquals(a * b * c, Double.POSITIVE_INFINITY);
    }

    // 1d.Проверить тип входных параметров
    @Test(dataProvider = "dataForValidation")
    public void testTypeElement(double a, double b, double c) {
        double d = a;
        assertSame(a, d);
    }

    // 1e.Проверить неправильное количество аргументов

}